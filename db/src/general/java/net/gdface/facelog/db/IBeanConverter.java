// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: $db.driver
// ______________________________________________________

package net.gdface.facelog.db;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        public AbstractHandle() {
        }
        /** copy right -> left, left and right must not be null */
        protected abstract void _fromRight(L left, R right);
        /** copy left -> right, left and right must not be null */
        protected abstract void _toRight(L left, R right);
        protected abstract L _newInstanceL();
        protected abstract R _newInstanceR();
        
        @Override
        public L fromRight(L left, R right) {
            if(null != right){
                if(null == left)
                    left = this._newInstanceL();
                this._fromRight(left, right);
            }            
            return left;
        }

        @Override
        public R toRight(L left, R right) {
            if(null != left){
                if(null == right)
                    right = this._newInstanceR();
                this._toRight(left, right);
            }
            return right;
        }

        @Override
        public L fromRight(R bean) {
            return fromRight(_newInstanceL(),bean);
        }

        @Override
        public R toRight(L bean) {
            return toRight(bean,_newInstanceR());
        }

        @SuppressWarnings("unchecked")
        @Override
        public R[] toRight(L[] lefts, R[] rights) {
            if(null != lefts){
                if(null == rights){
                    rights=(R[]) new Object[lefts.length];
                }
                if( lefts.length != rights.length)
                    throw new IllegalArgumentException("mismatched length between left and right array");
                for(int i=0;i<lefts.length;++i){
                    this.toRight(lefts[i],rights[i]);
                }
            }
            return rights;
        }

        @SuppressWarnings("unchecked")
        @Override
        public L[] fromRight(L[] lefts, R[] rights) {
            if(null != rights){
                if(null == lefts){
                    lefts=(L[]) new Object[rights.length];
                }
                if( lefts.length != rights.length)
                    throw new IllegalArgumentException("mismatched length between left and right array");
                for(int i=0;i<lefts.length;++i){
                    this.fromRight(lefts[i],rights[i]);
                }
            }
            return lefts;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public R[] toRight(L[] beans) {
            return this.toRight(beans,(R[]) new Object[beans.length]);
        }

        @SuppressWarnings("unchecked")
        @Override
        public L[] fromRight(R[] beans) {
            return this.fromRight( (L[]) new Object[beans.length],beans);
        }

        @Override
        public List<R> toRight(Collection<L> beans) {
            if(null==beans)return null;
            ArrayList<R> rights = new ArrayList<R>();
            for(L g:beans){
                rights.add(this.toRight(g));
            }
            return rights;
        }

        @Override
        public List<L> fromRight(Collection<R> beans) {
            if(null==beans)return null;
            ArrayList<L> lefts = new ArrayList<L>();
            for(R n:beans){
                lefts.add(this.fromRight(n));
            }
            return lefts;
        }

        @Override
        public List<R> toRight(List<L> lefts, List<R> rights) {
            if(null != lefts){
                if(null == rights){
                    rights=(List<R>) new ArrayList<R>();
                }
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
            if(null != rights){
                if(null == lefts){
                    lefts=(List<L>) new ArrayList<L>();
                }
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
            if(null == beans)return null;
            return this.toRight(beans,new ArrayList<R>(beans.size()));
        }

        @Override
        public List<L> fromRight(List<R> beans) {
            if(null == beans)return null;
            return this.fromRight(new ArrayList<L>(beans.size()),beans);
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

}
