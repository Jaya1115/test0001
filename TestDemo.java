class User{
	private String uid;
	private String username;
	private String password;
	private Role role;

	public User(String uid,String username,String password){
		this.uid=uid;
		this.username=username;
		this.password=password;
	}

	public void setRole(Role role){
		this.role=role;
		
	}
	public Role getRole(){
		return role;
	}

	public String getInfo(){
		return "用户id："+this.uid+",用户名："+this.username+",密码："+this.password;
	}

}
class Role{
	private String rid;
	private String rolename;
	private User[] users;
	private Group[] groups;

	public Role(String rid,String rolename){
		this.rid=rid;
		this.rolename=rolename;
	}
	public User[] getUsers(){
		return this.users;
	}
	public void setUsers(User[] users){
		this.users=users;
	}
	public Group[] getGroups(){
		return this.groups;
	}
	public void setGroups(Group[] groups){
		this.groups=groups;
	}

	public String getInfo(){
		return "角色编号："+this.rid+"，角色名称："+this.rolename;
	}
}

class Group{
	private String gid;
	private String gname;
	private Action[] actions;
	private Role[] roles;

	public Group(String gid,String gname){
		this.gid=gid;
		this.gname=gname;
	}
	public Action[] getActions(){
		return this.actions;
	}
	public void setActions(Action[] actions){
		this.actions=actions;
	}
	public Role[] getRoles(){
		return this.roles;
	}
	public void setRoles(Role[] roles){
		this.roles=roles;
	}

	public String getInfo(){
		return "权限组编号："+this.gid+"，权限组名称："+this.gname;
	}

}

class Action{
	private String aid;
	private String name;
	private String actionRoute;
	private Group group;

	public Action(String aid,String name,String actionRoute){
		this.aid=aid;
		this.name=name;
		this.actionRoute=actionRoute;
	}
	public Group getGroup(){
		return this.group;
	}
	public void setGroup(Group group){
		this.group=group;
	}

	public String getInfo(){
		return "权限编号："+this.aid+"，权限名称："+this.name+"，权限路径："+this.actionRoute;
	}
}

public class TestDemo{
	public static void main(String args[]){
		/*
		 *一、实例化类
		 */
		//1.用户
		User u1=new User("01","张鑫","123456");
		User u2=new User("02","王森","124456");
		User u3=new User("03","李明","125456");
		User u4=new User("04","赵兴","126456");
		//2.权限
		Action a1=new Action("a001","新闻管理","www.zjy.com/news");
		Action a2=new Action("a002","数据管理","www.zjy.com/datas");
		Action a3=new Action("a003","用户管理","www.zjy.com/users");
		Action a4=new Action("a004","系统管理","www.zjy.com/sys");
		Action a5=new Action("a005","栏目管理","www.zjy.com/columns");
		//3.权限组
		Group g1=new Group("g01","权限组一");
		Group g2=new Group("g02","权限组二");
		Group g3=new Group("g03","权限组三");
		//4.角色
		Role r1=new Role("r1","超级管理员");
		Role r2=new Role("r1","数据管理员");
		Role r3=new Role("r1","信息管理员");
		/*
		 *二、设置关系
		 */
		 //1.权限和权限组
		a1.setGroup(g1);
		a2.setGroup(g1);
		a3.setGroup(g2);
		a4.setGroup(g2);
		a5.setGroup(g3);
		g1.setActions(new Action[]{a1,a2});
		g2.setActions(new Action[]{a3,a4});
		g3.setActions(new Action[]{a5});
		 //2.角色和权限组
		r1.setGroups(new Group[]{g1,g2,g3});
		r2.setGroups(new Group[]{g2,g3});
		r3.setGroups(new Group[]{g1,g3});
		g1.setRoles(new Role[]{r1,r3});
		g2.setRoles(new Role[]{r1,r2});
		g3.setRoles(new Role[]{r1,r2,r3});
		 //3.用户和角色ja
		 u1.setRole(r1);
		 u2.setRole(r2);
		 u3.setRole(r3);
		 u4.setRole(r3);
		 r1.setUsers(new User[]{u1});
		 r2.setUsers(new User[]{u2});
		 r3.setUsers(new User[]{u3,u4});
		/*
		 *三、按要求通过用户取出关联的角色的权限的详情信息
		 */
		System.out.println(u1.getInfo());
		Group[] groups=u1.getRole().getGroups();

		for(int i=0;i<groups.length;i++){
			for(int j=0;j<groups[i].getActions().length;j++){
				System.out.println(groups[i].getActions()[j].getInfo());
			
			}
		}


	}

}