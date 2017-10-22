// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
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
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

import net.gdface.facelog.client.CollectionUtils.DualTransformer;

import static com.google.common.base.Preconditions.checkNotNull;

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
        if(null == buffer)return null;
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
        if(null == in)return null;
        if(in instanceof FileInputStream)
            return toBytes((FileInputStream)in);
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
        if(null == fin)return null;
        FileChannel fc = fin.getChannel();
        try {
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
            fc.read(bb);
            bb.flip();
            return bb.array();
        } finally {
            if (null != fc)
                fc.close();
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
        if(null == src)return null;
        if (src instanceof InputStream)
            return (InputStream) src;
        else if (src instanceof String) {
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
        } else
            throw new IllegalArgumentException(String.format("Can't get inputstream from [%s]", src.getClass()
                    .getCanonicalName()));
    }

    /**
     * 将数据对象{@code src}转换为字节数组(byte[])<br>
     * {@code src}的数据类型可以是byte[],{@link InputStream},{@link ByteBuffer},{@link String}(base64编码),{@link File},{@link URL},{@link URI}
     * 否则抛出{@link IllegalArgumentException}<br>
     * 对象转换为InputStream或byte[]时,可能会抛出{@link IOException}
     * 
     * 当{@code src}为{@link File}或{@link FileInputStream}时，使用NIO方式({@link #toBytes(FileInputStream)})读取
     * 
     * @param src
     *            获取byte[]的源对象
     * @return 返回字节数组,参数类型不对则抛出异常
     * @see #toBytes(InputStream)
     * @see #toBytes(FileInputStream)
     * @see #getInputStream(Object)
     * @see Base64Utils#decode(String)
     */
    static public final <T> byte[] toBytes(T src) {
        if(null == src)return null;    
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
            throw new IllegalArgumentException(e);
        }
    }
    private static final CollectionUtils.DualTransformer<ByteBuffer,byte[]> byteBufferdualTransformer = new CollectionUtils.DualTransformer<ByteBuffer,byte[]>(){
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
        if(null == source)return null;
        return CollectionUtils.tranformKeys(source, byteBufferdualTransformer);
    }
    private static final EntryTransformer<Object,ByteBuffer,byte[]> byteBuffertransformer = new EntryTransformer<Object,ByteBuffer,byte[]>(){
        @Override
        public byte[] transformEntry(Object key, ByteBuffer value) {
             return byteBufferdualTransformer.toRight(value);
        }};
    /** get a view of {@code Map<K,ByteBuffer>} with {@code byte[]} value type */
    public static final<K> Map<K,byte[]> toBytesValue(Map<K,ByteBuffer> source){
        if(null == source)return null;
        return Maps.transformEntries(source, byteBuffertransformer);
    }
    private static final Function<ByteBuffer,byte[]> toRightByteBuffer = new Function<ByteBuffer,byte[]>(){
        @Override
        public byte[] apply(ByteBuffer input) {
            return byteBufferdualTransformer.toRight(input);
        }};
    public static final List<byte[]> toBytes(List<ByteBuffer>source){
        return Lists.transform(source, toRightByteBuffer);
    }
    public static final Collection<byte[]> toBytes(Collection<ByteBuffer>source){
        return Collections2.transform(source, toRightByteBuffer);
    }
    static  class DateDualTransformer<D extends Date>
    implements CollectionUtils.DualTransformer<D, Long>{

        private Constructor<D> constructor;

        DateDualTransformer(Class<D>clazz){
            checkNotNull(clazz);
            try {
                constructor = clazz.getConstructor(long.class);
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
    public static final Long toLong(Date date,Class<?>clazz){
        return null == date ? null : date.getTime();
    }
    /** get a view of {@code Map<Date,V>} with {@code Long} key & value type */
    public static final<D extends Date,V>Map<Long,V> toLongKey(Map<D,V> source,Class<D>clazz){
        if(null == source)return null;
        return CollectionUtils.tranformKeys(source, new DateDualTransformer<D>(clazz));
    }

    private static final EntryTransformer<Object,Date,Long> dateLongTransformer = new EntryTransformer<Object,Date,Long>(){
        @Override
        public Long transformEntry(Object key, Date value) {
            return null == value? null:value.getTime();
        }};
    /** get a view of {@code Map<K,Date>} with {@code Long} value type */
    public static final<K,D extends Date> Map<K,Long> toLongValue(Map<K,D> source,Class<?>clazz){
        if(null == source)return null;
        return Maps.transformEntries(source, dateLongTransformer);
    }
    /** get a view of {@code Map<Date,Date>} with {@code Long} key type */
    public static final<D extends Date>Map<Long,Long> toLong(Map<D,D> source,Class<D>clazz){
        if(null == source)return null;
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        Map<Long, D> m = CollectionUtils.tranformKeys(source, trans);
       return  Maps.transformEntries(m, new EntryTransformer<Long,D,Long>(){           
            @Override
            public Long transformEntry(Long key, D value) {
                return trans.toRight(value);
            }});
    }
    
    private static final Function<Date,Long> tolongTransformer = new Function<Date,Long>(){
        @Override
        public Long apply(Date input) {
            return input.getTime();
        }};
    public static final List<Long> toLong(List<Date>source,Class<?>clazz){
        return Lists.transform(source, tolongTransformer);
    }
    public static final<D extends Date> Set<Long> toLong(Set<D>source,Class<D>clazz){
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        return CollectionUtils.transform(source, trans);
    }
    public static final Collection<Long> toLong(Collection<Date>source,Class<?>clazz){
        return Collections2.transform(source, tolongTransformer);
    }
    public static final<D extends Date> D toDate(Long date,Class<D> clazz){
        return null == date ? null : new DateDualTransformer<D>(clazz).fromRight(date);
    }
    /** get a view of {@code Map<Long,V>} with {@code Date} key type */
    public static final<D extends Date,V>Map<D,V> toDateKey(Map<Long,V> source,Class<D>clazz){
        if(null == source)return null;
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        return CollectionUtils.tranformKeys(source, new CollectionUtils.DualTransformer<Long,D>(){            
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
    public static final<K,D extends Date> Map<K,D> toDateValue(Map<K,Long> source,Class<D>clazz){
        if(null == source)return null;
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz); 
        return Maps.transformEntries(source, new EntryTransformer<K,Long,D>(){
            @Override
            public D transformEntry(K key, Long value) {
                return trans.fromRight(value);
            }});
    }
    /** get a view of {@code Map<Long,Long>} with {@code Date} key & value type */
    public static final<D extends Date>Map<D,D> toDate(Map<Long,Long> source,Class<D>clazz){
        if(null == source)return null;
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        final DualTransformer<Long, D> trans2 = new CollectionUtils.DualTransformer<Long,D>(){            
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

    public static final<D extends Date> List<D> toDate(List<Long>source,Class<D>clazz){
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        return Lists.transform(source, new Function<Long,D>(){
            @Override
            public D apply(Long input) {
                return trans.fromRight(input);
            }});
    }
    public static final<D extends Date> Set<D> toDate(Set<Long>source,Class<D>clazz){
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        final DualTransformer<Long, D> trans2 = new CollectionUtils.DualTransformer<Long,D>(){            
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
    public static final<D extends Date> Collection<D> toDate(Collection<Long>source,Class<D>clazz){
        final DateDualTransformer<D> trans = new DateDualTransformer<D>(clazz);
        return Collections2.transform(source, new Function<Long,D>(){
            @Override
            public D apply(Long input) {
                return trans.fromRight(input);
            }});
    }
}
