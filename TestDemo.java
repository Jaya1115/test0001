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
		return "�û�id��"+this.uid+",�û�����"+this.username+",���룺"+this.password;
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
		return "��ɫ��ţ�"+this.rid+"����ɫ���ƣ�"+this.rolename;
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
		return "Ȩ�����ţ�"+this.gid+"��Ȩ�������ƣ�"+this.gname;
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
		return "Ȩ�ޱ�ţ�"+this.aid+"��Ȩ�����ƣ�"+this.name+"��Ȩ��·����"+this.actionRoute;
	}
}

public class TestDemo{
	public static void main(String args[]){
		/*
		 *һ��ʵ������
		 */
		//1.�û�
		User u1=new User("01","����","123456");
		User u2=new User("02","��ɭ","124456");
		User u3=new User("03","����","125456");
		User u4=new User("04","����","126456");
		//2.Ȩ��
		Action a1=new Action("a001","���Ź���","www.zjy.com/news");
		Action a2=new Action("a002","���ݹ���","www.zjy.com/datas");
		Action a3=new Action("a003","�û�����","www.zjy.com/users");
		Action a4=new Action("a004","ϵͳ����","www.zjy.com/sys");
		Action a5=new Action("a005","��Ŀ����","www.zjy.com/columns");
		//3.Ȩ����
		Group g1=new Group("g01","Ȩ����һ");
		Group g2=new Group("g02","Ȩ�����");
		Group g3=new Group("g03","Ȩ������");
		//4.��ɫ
		Role r1=new Role("r1","��������Ա");
		Role r2=new Role("r1","���ݹ���Ա");
		Role r3=new Role("r1","��Ϣ����Ա");
		/*
		 *�������ù�ϵ
		 */
		 //1.Ȩ�޺�Ȩ����
		a1.setGroup(g1);
		a2.setGroup(g1);
		a3.setGroup(g2);
		a4.setGroup(g2);
		a5.setGroup(g3);
		g1.setActions(new Action[]{a1,a2});
		g2.setActions(new Action[]{a3,a4});
		g3.setActions(new Action[]{a5});
		 //2.��ɫ��Ȩ����
		r1.setGroups(new Group[]{g1,g2,g3});
		r2.setGroups(new Group[]{g2,g3});
		r3.setGroups(new Group[]{g1,g3});
		g1.setRoles(new Role[]{r1,r3});
		g2.setRoles(new Role[]{r1,r2});
		g3.setRoles(new Role[]{r1,r2,r3});
		 //3.�û��ͽ�ɫja
		 u1.setRole(r1);
		 u2.setRole(r2);
		 u3.setRole(r3);
		 u4.setRole(r3);
		 r1.setUsers(new User[]{u1});
		 r2.setUsers(new User[]{u2});
		 r3.setUsers(new User[]{u3,u4});
		/*
		 *������Ҫ��ͨ���û�ȡ�������Ľ�ɫ��Ȩ�޵�������Ϣ
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