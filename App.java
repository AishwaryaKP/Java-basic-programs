package com.abc.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.abc.entity.Student;

public class App {

	public static void main(String[] args)
	{
		SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
    Session session=sessionFactory.openSession();
		session.beginTransaction();
		Scanner scan=new Scanner(System.in);
		int choice=0;
		while(choice==0)
		{
		System.out.println("Enter your choice");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Display");
		choice=scan.nextInt();
			switch(choice)
			{
		case 1:	
		System.out.println("Enter the  number of rows");
		int rows=scan.nextInt();
		for(int i=0;i<=rows-1;i++)
		{
			System.out.println("Enter the roll,name,marks");
			Student s=new Student(scan.nextInt(),scan.next(),scan.nextInt());
			session.save(s);
			session.getTransaction().commit();	
		}
		return;
		
			case 2:
		  System.out.println("Enter the id"); 
		  int id=scan.nextInt();
		  System.out.println("Enter the marks"); 
		  int marks=scan.nextInt(); Student
		  s=session.get(Student.class, id);//name=sharma roll=2 marks=45
		  s.setMarks(marks); 
		  session.update(s);
		  session.getTransaction().commit();
		  return;
		
			case 3:
		  Query q=session.createQuery("Delete from Student s where s.id=:id1");
		  System.out.println("Enter the ID");
		  int id1=scan.nextInt();
		  q.setParameter("id1", id1);
		  int rows1=q.executeUpdate();
		  System.out.println("Rows deleted: "+rows1);
		  session.getTransaction().commit();
		 return;
		
		  
		  
			case 4:
			List list1=session.createQuery("from Student").getResultList();
			Iterator itr=list1.iterator();
			if(itr.hasNext())
			{
				
				System.out.println(itr.next());
			}
			else
			{
				System.out.println("No Data Present");
			}
			session.getTransaction().commit();
			return;
			
			default:System.out.println("WRONG CHOICE");
			return;
			}
	}

}
	
}
