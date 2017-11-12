package gu.simplemq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import gu.simplemq.IKeyHelper;
import gu.simplemq.redis.RedisFactory;
import gu.simplemq.redis.RedisTable;
/**
 * @author guyadong
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisTableTest {
	private static final Logger logger = LoggerFactory.getLogger(RedisTableTest.class);

	public interface Person<T>{
		
	}
	public static class User implements Person<String>{

	    private Long   id;
	    private String name;


	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	}
	public static  class Group {

	    private Long       id;
	    private String     name;
	    private List<User> users = new ArrayList<User>(16);
	    public Date date=new Date();
	    public java.sql.Date sqldate=new java.sql.Date(date.getTime());
	    public byte[] array=new byte[]{22,33,3,2,3,1,5,-1};
	    public String nullStr=null;
	    private String privString="private string";
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<User> getUsers() {
	        return users;
	    }

	    public void setUsers(List<User> users) {
	        this.users = users;
	    }

	        public void addUser(User user) {
	            users.add(user);
	        }
	}
	
	
	@Test
	public void test1SetGet() {
		Group group = new Group();
		group.setId(100L);
		group.setName("admin");

		User guestUser = new User();
		guestUser.setId(2L);
		guestUser.setName("guest");

		User rootUser = new User();
		rootUser.setId(3L);
		rootUser.setName("root");

		group.addUser(guestUser);
		group.addUser(rootUser);
		RedisTable<Group> table = RedisFactory.getTable(Group.class);
		table.setKeyHelper(new IKeyHelper<Group>(){
			@Override
			public String returnKey(Group v) {
				return v.getId().toString();
			}});
		table.set(group, false);
		System.out.println(JSON.toJSONString(group,SerializerFeature.WriteMapNullValue));
		Group deserialized = table.get(group.getId().toString());
		System.out.println(JSON.toJSONString(deserialized,SerializerFeature.WriteMapNullValue));
	}
	@Test
	public void test2GetSetField() {
		RedisTable<Group> table = RedisFactory.getTable(Group.class);
		table.setField("100", "nullStr", null, false);
		System.out.println(table.getField("100", "nullStr"));
	}
	
	@Test
	public void test3GetFields(){
		RedisTable<Group> table = RedisFactory.getTable(Group.class);
		Map<String, Object> values = table.getFields("100", (String[])null);
		for(Entry<String, Object> entry:values.entrySet()){
			System.out.printf("%s %s\n",entry.getKey(),entry.getValue());
		}
	}
	
	@Test
	public void test4GetFieldNames(){
		RedisTable<Group> table = RedisFactory.getTable(Group.class);
		for(String field:table.getFieldNames()){
			logger.info(field);
		}
	}
}