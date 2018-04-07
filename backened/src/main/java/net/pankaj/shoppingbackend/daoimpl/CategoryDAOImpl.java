package net.pankaj.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.pankaj.shoppingbackend.dao.CategoryDAO;
import net.pankaj.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl  implements CategoryDAO{
private static List<Category> categories=new ArrayList<>();
static {
	
	Category c1=new Category();
	c1.setId(1);
	c1.setName("tv");
	c1.setDescription("D1");
	c1.setImageURL("i1");
	//c1.setActive(true);
	categories.add(c1);
	
	Category c2=new Category();
	c2.setId(2);
	c2.setName("Mobiles");
	c2.setDescription("D2");
	c2.setImageURL("i2");
	//c1.setActive(true);
	categories.add(c2);
}	
@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
@Override
public Category get(int id) {
for(Category c:categories) {
	if(c.getId()==id)
		return c;
}	
return null;
}
	

}
