// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: ibean.converter.java.vm
// ______________________________________________________
package net.gdface.facelog.client;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author guyadong
 *
 * @param <L> left type
 * @param <R> right type
 */
public interface IBeanConverter<L,R> {

    /**
     * Default abstract implementation of {@link IBeanConverter}<br>
     * 
     * @author guyadong
     *
     * @param <L> left type
     * @param <R> right type
     */
    public static abstract class  AbstractHandle <L,R>implements IBeanConverter<L, R> {
        /** L type  */
        protected final Class<?> leftType;
        /** R type  */
        protected final Class<?> rightType;
        private static Class<?> getRawClass(Type type){
            if(type instanceof Class<?>){
                return (Class<?>) type;
            } else if(type instanceof ParameterizedType){
                return getRawClass(((ParameterizedType) type).getRawType());
            } else{
                throw new IllegalArgumentException("invalid type");
            }
        }
        public AbstractHandle() {
            Type superClass = getClass().getGenericSuperclass();
            this.leftType = getRawClass(((ParameterizedType) superClass).getActualTypeArguments()[0]);
            this.rightType = getRawClass(((ParameterizedType) superClass).getActualTypeArguments()[1]);
        }
        public AbstractHandle(Class<L> leftClass,Class<R> rightClass) {
            this.leftType = leftClass;
            this.rightType = rightClass;
        }
        /** copy right -> left, left and right must not be null */
        protected abstract void _fromRight(L left, R right);
        /** copy left -> right, left and right must not be null */
        protected abstract void _toRight(L left, R right);
        /**
         *  Creates a new  L instance by calling constructor with an empty argument list<br>
         *  you must override the method if the L class haven't default constructor.
         * @return
         */
        @SuppressWarnings("unchecked")
        protected L _newInstanceL(){ return (L) _newInstance(this.leftType); }
        /**
         *  Creates a new R instance by calling constructor with an empty argument list<br>
         *  you must override the method if the R class haven't default constructor.
         * @return
         */
        @SuppressWarnings("unchecked")
        protected R _newInstanceR(){ return (R) _newInstance(this.rightType); }
        
        protected  static<T> T _newInstance(Class<T>clazz){
            try {
                return (T) clazz.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        private R[] makeRights(L[] lefts){
            if(null == lefts)return null;
            @SuppressWarnings("unchecked")
            R[] rights = (R[])java.lang.reflect.Array.newInstance(rightType,lefts.length) ;
            for(int i=0;i<rights.length;++i){
                rights[i]=null == lefts[i]?null:_newInstanceR();
            }
            return rights;
        }
        private L[] makeLefts(R[] rights){
            if(null == rights)return null;
            @SuppressWarnings("unchecked")
            L[] lefts = (L[])java.lang.reflect.Array.newInstance(leftType,rights.length) ;
            for(int i=0;i<lefts.length;++i){
                lefts[i]=null == rights[i]?null:_newInstanceL();
            }
            return lefts;
        }
        private List<R> makeRights(List<L> lefts){
            if(null == lefts)return null;
            ArrayList<R> rights = new ArrayList<R>(lefts.size());
            for(int i=0;i<rights.size();++i){
                rights.add (null == lefts.get(i)?null:_newInstanceR());
            }
            return rights;
        }
        private List<L> makeLefts(List<R> rights){
            if(null == rights)return null;
            ArrayList<L> lefts = new ArrayList<L>(rights.size());
            for(int i=0;i<lefts.size();++i){
                lefts.add (null == rights.get(i)?null:_newInstanceL());
            }
            return lefts;
        }
        @Override
        public L fromRight(L left, R right) {
            if(null != right && null != left){
                this._fromRight(left, right);
            }            
            return left;
        }

        @Override
        public R toRight(L left, R right) {
            if(null != left && null != right){
                this._toRight(left, right);
            }
            return right;
        }

        @Override
        public L fromRight(R bean) {
            return null == bean? null : fromRight(_newInstanceL(),bean);
        }

        @Override
        public R toRight(L bean) {
            return null == bean? null : toRight(bean,_newInstanceR());
        }

        @Override
        public R[] toRight(L[] lefts, R[] rights) {
            if(null != lefts && null != rights){
                if( lefts.length != rights.length)
                    throw new IllegalArgumentException("mismatched length between left and right array");
                for(int i=0;i<lefts.length;++i){
                    this.toRight(lefts[i],rights[i]);
                }
            }
            return rights;
        }

        @Override
        public L[] fromRight(L[] lefts, R[] rights) {
            if(null != rights && null != lefts){
                if( lefts.length != rights.length)
                    throw new IllegalArgumentException("mismatched length between left and right array");
                for(int i=0;i<lefts.length;++i){
                    this.fromRight(lefts[i],rights[i]);
                }
            }
            return lefts;
        }
        
        @Override
        public R[] toRight(L[] beans) {
            return this.toRight(beans,makeRights(beans));
        }

        @Override
        public L[] fromRight(R[] beans) {
            return this.fromRight( makeLefts(beans),beans);
        }

        @Override
        public List<R> toRight(Collection<L> beans) {
            if(null==beans)return null;
            ArrayList<R> rights = new ArrayList<R>(beans.size());
            for(L g:beans){
                rights.add(this.toRight(g));
            }
            return rights;
        }

        @Override
        public List<L> fromRight(Collection<R> beans) {
            if(null==beans)return null;
            ArrayList<L> lefts = new ArrayList<L>(beans.size());
            for(R n:beans){
                lefts.add(this.fromRight(n));
            }
            return lefts;
        }

        @Override
        public List<R> toRight(List<L> lefts, List<R> rights) {
            if(null != lefts && null != rights){
                if( lefts.size() != rights.size())
                    throw new IllegalArgumentException("mismatched length between left and right list");
                for(int i=0;i<lefts.size();++i){
                    this.toRight(lefts.get(i),rights.get(i));
                }
            }
            return rights;
        }

        @Override
        public List<L> fromRight(List<L> lefts, List<R> rights) {
            if(null != rights && null != lefts){
                if( lefts.size() != rights.size())
                    throw new IllegalArgumentException("mismatched length between left and right list");
                for(int i=0;i<lefts.size();++i){
                    this.fromRight(lefts.get(i),rights.get(i));
                }
            }
            return lefts;
        }

        @Override
        public List<R> toRight(List<L> beans) {
            return this.toRight(beans,makeRights(beans));
        }

        @Override
        public List<L> fromRight(List<R> beans) {
            return this.fromRight(makeLefts(beans),beans);
        }
        @Override
        public<V> Map<R,V> toRightKey(Map<L,V> lmap) {
            if(null == lmap)return null;
            HashMap<R,V> rmap = new HashMap<R,V>();
            for(Entry<L, V> entry:lmap.entrySet()){
                rmap.put(this.toRight(entry.getKey()),entry.getValue());
            }
            return rmap;
        }
        @Override
        public<K> Map<K,R> toRightValue(Map<K,L> lmap) {
            if(null == lmap)return null;
            HashMap<K, R> rmap = new HashMap<K, R>();
            for(Entry<K, L> entry:lmap.entrySet()){
                rmap.put(entry.getKey(), this.toRight(entry.getValue()));
            }
            return rmap;
        }
        @Override
        public<V> Map<L,V> fromRightKey(Map<R,V> rmap) {
            if(null == rmap)return null;
            HashMap<L,V> lmap = new HashMap<L,V>();
            for(Entry<R, V> entry:rmap.entrySet()){
                lmap.put(this.fromRight(entry.getKey()),entry.getValue());
            }
            return lmap;
        }
        @Override
        public<K> Map<K,L> fromRightValue(Map<K,R> rmap) {
            if(null == rmap)return null;
            HashMap<K, L> lmap = new HashMap<K, L>();
            for(Entry<K, R> entry:rmap.entrySet()){
                lmap.put(entry.getKey(), this.fromRight(entry.getValue()));
            }
            return lmap;
        }
        @Override
        public Map<R,R> toRight(Map<L,L> lmap) {
            if(null == lmap)return null;
            HashMap<R,R> rmap = new HashMap<R,R>();
            for(Entry<L, L> entry:lmap.entrySet()){
                rmap.put(this.toRight(entry.getKey()),this.toRight(entry.getValue()));
            }
            return rmap;
        }
        @Override
        public Map<L,L> fromRight(Map<R,R> rmap) {
            if(null == rmap)return null;
            HashMap<L,L> lmap = new HashMap<L,L>();
            for(Entry<R, R> entry:rmap.entrySet()){
                lmap.put(this.fromRight(entry.getKey()),this.fromRight(entry.getValue()));
            }
            return lmap;
        }
    }

    /**
     * copy right -> left
     * @param left
     * @param right
     * @return left,or new instance if left is null
     */
    public L fromRight(L left, R right);
    
    /**
     * copy left -> right
     * @param left
     * @param right
     * @return right,or new instance if right is null
     */
    public R toRight(L left, R right);
    /**
     * @param bean
     * @return an new instance converted from R bean
     */
    public L fromRight(R bean);
    /**
     * @param bean
     * @return an new instance converted from L bean
     */
    public R toRight( L bean);
    /**
     * copy rights -> lefts
     * @param lefts
     * @param rights
     * @return lefts,or new array if lefts is null
     */
    public L[] fromRight(L[] lefts,R[] rights);
    /**
     * copy lefts -> rights
     * @param lefts
     * @param rights
     * @return rights,or new array if rights is null
     */
    public R[] toRight(L[] lefts,R[] rights);
    /**
     * @param beans
     * @return an new array converted from R beans
     */
    public L[] fromRight(R[] beans);
    /**
     * @param beans
     * @return an new array converted from L beans
     */
    public R[] toRight(L[] beans);
    /**
     * copy rights -> lefts
     * @param lefts
     * @param rights
     * @return lefts,or new array if lefts is null
     */
    public List<L> fromRight(List<L> lefts,List<R> rights);
    /**
     * copy lefts -> rights
     * @param lefts
     * @param rights
     * @return rights,or new array if rights is null
     */
    public List<R> toRight(List<L> lefts,List<R> rights);
    /**
     * @param beans
     * @return an new list converted from R beans
     */
    public List<L> fromRight(List<R> beans);
    /**
     * @param beans
     * @return an new list converted from L beans
     */
    public List<R> toRight(List<L> beans);
    /**
     * @param beans
     * @return an new list converted from R beans
     */
    public List<L> fromRight(Collection<R> beans);
    /**
     * @param beans
     * @return an new list converted from L beans
     */
    public List<R> toRight(Collection<L> beans);
    
    /**
     * @param lmap
     * @return an new map with R key converted from map with L key
     */
    public <V> Map<R,V> toRightKey(Map<L,V> lmap);
    /**
     * @param lmap
     * @return an new map with R value converted from map with L value
     */
    public <K> Map<K,R> toRightValue(Map<K,L> lmap);
    /**
     * @param rmap
     * @return an new map with L key converted from map with R key
     */
    public <V> Map<L,V> fromRightKey(Map<R,V> rmap);
    /**
     * @param rmap
     * @return an new map with L value converted from map with R value
     */
    public <K> Map<K,L> fromRightValue(Map<K,R> rmap);
    /**
     * @param lmap
     * @return an new map with R key and  R value converted from map with L key and L value
     */
    public Map<R,R> toRight(Map<L,L> lmap);
    /**
     * @param rmap
     * @return an new map with L key and  L value converted from map with R key and R value
     */
    public Map<L,L> fromRight(Map<R,R> rmap);
}
