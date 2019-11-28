package demo;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalLearning {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try 
		{
			System.out.println(Optional.ofNullable(null).map((e)->{ return e;}).orElseThrow(()-> new Exception("Null Pointer")));
		}
		catch (Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		

	}
	
	List<String> returnNull()
	{
		return null;
	}

}
