// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: generic.utils.java.vm
// ______________________________________________________
package net.gdface.facelog.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

import net.gdface.facelog.client.CollectionUtils.DualTransformer;

import static com.google.common.base.Preconditions.*;

/**
 * @author guyadong
 *
 */
public class GenericUtils {
    /**
     * 返回buffer中所有字节(position~limit),不改变buffer状态
     * @param buffer
     * @return buffer 为 null 时返回 null 
     */
    public static final byte[] toBytes(ByteBuffer buffer){
        if(null == buffer){
            return null;
        }
        int pos = buffer.position();
        try{
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            return bytes;
        }finally{
            buffer.position(pos);
        }
    }
    /**
     * 从{@link InputStream}读取字节数组<br>
     * 当{@code in}为{@link FileInputStream}时，调用{@link #toBytes(FileInputStream)}(NIO方式)读取<br>
     *  结束时会关闭{@link InputStream}
     * @param in
     * @return
     * @throws IOException
     * @throws IllegalArgumentException {@code in}为{@code null}
     */
    private static byte[] toBytes(InputStream in) throws IOException, IllegalArgumentException {
        if(null == in){
            return null;
        }
        if(in instanceof FileInputStream){
            return toBytes((FileInputStream)in);
        }
        try {
            int buffSize = Math.max(in.available(), 1024*8);
            byte[] temp = new byte[buffSize];
            ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
            return  out.toByteArray();
        } finally {
            in.close();
        }
    }
    
    /**
     * NIO方式从{@link FileInputStream}读取字节数组<br>
     *  结束时会关闭{@link InputStream}
     * @param fin {@link FileInputStream}
     * @return 返回读取的字节数 当{@code fin}为null时返回null;
     * @throws IOException
     */
    private static byte[] toBytes(FileInputStream fin) throws IOException {
        if(null == fin){
            return null;
        }
        FileChannel fc = fin.getChannel();
        try {
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
            fc.read(bb);
            bb.flip();
            return bb.array();
        } finally {
            if (null != fc){
                fc.close();
            }
            fin.close();
        }
    }
    /**
     * 将对象转换为InputStream<br>
     * 类型可以是byte[],{@link ByteBuffer},{@link InputStream},{@link String}(base64编码),{@link File},{@link URL},{@link URI},否则抛出RuntimeException<br>
     * 
     * @param src
     *            获取InputStream的源对象
     * @return 返回获取的InputStream对象
     * @throws IOException 
     */
    private static <T> InputStream getInputStream(T src) throws IOException {
        if(null == src){
            return null;
        }
        if (src instanceof InputStream){
            return (InputStream) src;
        } else if (src instanceof String) {
            return new ByteArrayInputStream(Base64Utils.decode(((String) src)));
        } else if (src instanceof byte[]) {
            return new ByteArrayInputStream((byte[]) src);
        } else if (src instanceof ByteBuffer) {
            return new ByteArrayInputStream(toBytes((ByteBuffer) src));
        } else if (src instanceof File) {
            return new FileInputStream((File) src);
        } else if (src instanceof URL) {
            return ((URL) src).openStream();
        } else if (src instanceof URI) {
            return ((URI) src).toURL().openStream();
        } else{
            throw new IllegalArgumentException(String.format("Can't get inputstream from [%s]", src.getClass()
                    .getCanonicalName()));
        }
    }

    /**
     * 从数据对象{@code src}读取二进制数据(byte[])<br>
     * {@code src}的数据类型可以是{@code byte[]},{@link InputStream},{@link ByteBuffer},{@link String}(base64编码),{@link File},{@link URL},{@link URI}
     * 否则抛出{@link IllegalArgumentException}<br>
     * 对象转换为{@code InputStream}或{@code byte[]}时,可能会抛出{@link IOException}(封装成{@link RuntimeException}抛出)<br>
     * 
     * @param src
     *            获取byte[]的源对象
     * @return 返回字节数组,参数类型不对则抛出异常,{@code src}为{@code null}时返回{@code null}
     * @see #toBytes(InputStream)
     * @see #toBytes(FileInputStream)
     * @see #getInputStream(Object)
     * @see Base64Utils#decode(String)
     */
    static public final <T> byte[] toBytes(T src) {
        if(null == src){
            return null;
        }
        try{
            if (src instanceof byte[]) {
                return (byte[]) src;
            } else if (src instanceof String) {
                return Base64Utils.decode(((String) src));
            } else if (src instanceof ByteBuffer) {
                return toBytes((ByteBuffer)src);
            } else if (src instanceof FileInputStream){
                return toBytes((FileInputStream)src);
            }else if (src instanceof File){
                return toBytes(new FileInputStream((File)src));
            }else {
                return toBytes(getInputStream(src));
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    private static final CollectionUtils.DualTransformer<ByteBuffer,byte[]> BYTE_BUFFER_DUAL_TRANSFORMER = new CollectionUtils.DualTransformer<ByteBuffer,byte[]>(){
        @Override
        public byte[] toRight(ByteBuffer input) {
            return toBytes(input);
        }
        @Override
        public ByteBuffer fromRight(byte[] input) {
            return null == input ? null : ByteBuffer.wrap(input);
        }};
    /** get a view of {@code Map<ByteBuffer,V>} with {@code byte[]} key type */
    public static final<V>Map<byte[],V> toBytesKey(Map<ByteBuffer,V> source){
        if(null == source){
            return null;
        }
        return CollectionUtils.tranformKeys(source, BYTE_BUFFER_DUAL_TRANSFORMER);
    }
    private static final EntryTransformer<Object,ByteBuffer,byte[]> BYTE_BUFFER_TRANSFORMER = new EntryTransformer<Object,ByteBuffer,byte[]>(){
        @Override
        public byte[] transformEntry(Object key, ByteBuffer value) {
             return BYTE_BUFFER_DUAL_TRANSFORMER.toRight(value);
        }};
    /** get a view of {@code Map<K,ByteBuffer>} with {@code byte[]} value type */
    public static final<K> Map<K,byte[]> toBytesValue(Map<K,ByteBuffer> source){
        if(null == source){
            return null;
        }
        return Maps.transformEntries(source, BYTE_BUFFER_TRANSFORMER);
    }
    private static final Function<ByteBuffer,byte[]> TO_RIGHT_BYTE_BUFFER = new Function<ByteBuffer,byte[]>(){
        @Override
        public byte[] apply(ByteBuffer input) {
            return BYTE_BUFFER_DUAL_TRANSFORMER.toRight(input);
        }};
    /** get a view of {@code List<ByteBuffer>} with {@code byte[]} type */
    public static final List<byte[]> toBytes(List<ByteBuffer>source){
        if(null == source){
            return null;
        }
        return Lists.transform(source, TO_RIGHT_BYTE_BUFFER);
    }
    /** get a view of {@code Collection<ByteBuffer>} with {@code byte[]} type */
    public static final Collection<byte[]> toBytes(Collection<ByteBuffer>source){
        if(null == source){
            return null;
        }
        return Collections2.transform(source, TO_RIGHT_BYTE_BUFFER);
    }
    static  class DateDualTransformer<D extends Date>
    implements CollectionUtils.DualTransformer<D, Long>{

        private Constructor<D> constructor;

        DateDualTransformer(Class<D>clazz){
            try {
                constructor = checkNotNull(clazz,"clazz is null").getConstructor(long.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public Long toRight(D input) {
            return null == input? null:input.getTime();
        }

        @Override
        public D fromRight(Long input) {
            try {
                return null == input ?null : constructor.newInstance(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    @SuppressWarnings("rawtypes")
    private static final LoadingCache<Class<? extends Date>, DateDualTransformer> DATE_TRANSFORMER_CACHE = CacheBuilder.newBuilder()
            .build(new CacheLoader<Class<? extends Date>, DateDualTransformer>(){
                @SuppressWarnings("unchecked")
                @Override
                public DateDualTransformer load(Class<? extends Date> key) throws Exception {
                    return new DateDualTransformer(key);
                }});
    /** transform Date to Long,return null if {@code source} is null */
    public static final Long toLong(Date source,Class<?>clazz){
        return null == source ? null : source.getTime();
    }
    /** get a view of {@code Map<Date,V>} with {@code Long} key type */
    @SuppressWarnings("unchecked")
    public static final<D extends Date,V>Map<Long,V> toLongKey(Map<D,V> source,Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return CollectionUtils.tranformKeys(source, DATE_TRANSFORMER_CACHE.getUnchecked(clazz));
    }

    private static final EntryTransformer<Object,Date,Long> DATE_ENTRY_TRANSFORMER = new EntryTransformer<Object,Date,Long>(){
        @Override
        public Long transformEntry(Object key, Date value) {
            return null == value? null:value.getTime();
        }};
    /** get a view of {@code Map<K,Date>} with {@code Long} value type */
    public static final<K,D extends Date> Map<K,Long> toLongValue(Map<K,D> source,Class<?>clazz){
        if(null == source){
            return null;
        }
        return Maps.transformEntries(source, DATE_ENTRY_TRANSFORMER);
    }
    /** get a view of {@code Map<Date,Date>} with {@code Long} key & value type */
    public static final<D extends Date>Map<Long,Long> toLong(Map<D,D> source,Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        @SuppressWarnings("unchecked")
        final DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
        Map<Long, D> m = CollectionUtils.tranformKeys(source, trans);
       return  Maps.transformEntries(m, new EntryTransformer<Long,D,Long>(){           
            @Override
            public Long transformEntry(Long key, D value) {
                return trans.toRight(value);
            }});
    }
    
    private static final Function<Date,Long> TO_LONG_FUN = new Function<Date,Long>(){
        @Override
        public Long apply(Date input) {
            return null == input ? null :input.getTime();
        }};
    /** get a view of {@code List<Date>} with {@code Long} type */
    public static final List<Long> toLong(List<Date>source,Class<?>clazz){
        if(null == source){
            return null;
        }
        return Lists.transform(source, TO_LONG_FUN);
    }
    /** get a view of {@code Set<Date>} with {@code Long} type */
    @SuppressWarnings("unchecked")
    public static final<D extends Date> Set<Long> toLong(Set<D>source,Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return CollectionUtils.transform(source, DATE_TRANSFORMER_CACHE.getUnchecked(clazz));
    }
    /** get a view of {@code Collection<Date>} with {@code Long} type */
    public static final Collection<Long> toLong(Collection<Date>source,Class<?>clazz){
        if(null == source){
            return null;
        }
        return Collections2.transform(source, TO_LONG_FUN);
    }
    /** transform Long to Date,return null if {@code source} is null */
    @SuppressWarnings("unchecked")
    public static final<D extends Date> D toDate(Long source,Class<D> clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return (D) DATE_TRANSFORMER_CACHE.getUnchecked(clazz).fromRight(source);
    }
    /** get a view of {@code Map<Long,V>} with {@code Date} key type */
    public static final<D extends Date,V>Map<D,V> toDateKey(Map<Long,V> source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return CollectionUtils.tranformKeys(source, new CollectionUtils.DualTransformer<Long,D>(){            
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
            @Override
            public D toRight(Long input) {
                return trans.fromRight(input);
            }
            @Override
            public Long fromRight(D input) {
                return trans.toRight(input);
            }});
    }
    /** get a view of {@code Map<K,Long>} with {@code Date} value type */
    public static final<K,D extends Date> Map<K,D> toDateValue(Map<K,Long> source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return Maps.transformEntries(source, new EntryTransformer<K,Long,D>(){
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz); 
            @Override
            public D transformEntry(K key, Long value) {
                return trans.fromRight(value);
            }});
    }
    /** get a view of {@code Map<Long,Long>} with {@code Date} key & value type */
    public static final<D extends Date>Map<D,D> toDate(Map<Long,Long> source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        final DualTransformer<Long, D> trans2 = new CollectionUtils.DualTransformer<Long,D>(){            
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans =DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
            @Override
            public D toRight(Long input) {
                return trans.fromRight(input);
            }
            @Override
            public Long fromRight(D input) {
                return trans.toRight(input);
            }};
        Map<D,Long> m = CollectionUtils.tranformKeys(source, trans2);
        return  Maps.transformEntries(m, new EntryTransformer<D,Long,D>(){
            @Override
            public D transformEntry(D key, Long value) {
                return trans2.toRight(value);
            }});
    }
    /** get a view of {@code List<Long>} with {@code Data} type */
    public static final<D extends Date> List<D> toDate(List<Long>source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return Lists.transform(source, new Function<Long,D>(){
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
            @Override
            public D apply(Long input) {
                return trans.fromRight(input);
            }});
    }
    /** get a view of {@code Set<Date>} with {@code Date} type */
    public static final<D extends Date> Set<D> toDate(Set<Long>source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        final DualTransformer<Long, D> trans2 = new CollectionUtils.DualTransformer<Long,D>(){ 
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
            @Override
            public D toRight(Long input) {
                return trans.fromRight(input);
            }
            @Override
            public Long fromRight(D input) {
                return trans.toRight(input);
            }};
        return CollectionUtils.transform(source, trans2);
    }
    /** get a view of {@code Collection<Date>} with {@code Date} type */
    public static final<D extends Date> Collection<D> toDate(Collection<Long>source,final Class<D>clazz){
        if(null == source){
            return null;
        }
        checkArgument(null != clazz,"clzzz is null");
        return Collections2.transform(source, new Function<Long,D>(){
            @SuppressWarnings("unchecked")
            DateDualTransformer<D> trans = DATE_TRANSFORMER_CACHE.getUnchecked(clazz);
            @Override
            public D apply(Long input) {
                return trans.fromRight(input);
            }});
    }
}
