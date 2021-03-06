package com.thephotogallery.admin.brand;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.thephotogallery.common.entity.Brand;
import com.thephotogallery.common.entity.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BrandRepositoryTests {
	
	@Autowired
	private BrandRepository repo;
	
	
	@Test
	public void testCreateBrand1() {
		Category bombers = new Category(4);
		Brand boeing = new Brand("Boeing");
		boeing.getCategories().add(bombers);
		
		Brand savedBrand = repo.save(boeing);
		
		assertThat(savedBrand).isNotNull();
		assertThat(savedBrand.getId()).isGreaterThan(0);
	}
	
	
	
	@Test
	public void testCreateBrand3() {
		Brand fighters = new Brand("Fighters");
		
		fighters.getCategories().add(new Category(9));
		fighters.getCategories().add(new Category(10));
		
		Brand savedBrand = repo.save(fighters);
		
		assertThat(savedBrand).isNotNull();
		assertThat(savedBrand.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testFindAll() {
		Iterable<Brand> brands = repo.findAll();
		brands.forEach(System.out::println);
		
		assertThat(brands).isNotEmpty();
	}
	
	@Test
	public void testGetById() {
		Brand brand = repo.findById(1).get();
		
		assertThat(brand.getName()).isEqualTo("Lockheed");
	}
	
	@Test
	public void testUpdateName() {
		String newName = "Aerobaltic Gdynia";
		Brand aerobaltic = repo.findById(23).get();
		aerobaltic.setName(newName);
		
		Brand savedBrand = repo.save(aerobaltic);
		assertThat(savedBrand.getName()).isEqualTo(newName);
	}
	
	@Test
	public void testDelete() {
		Integer id = 2;
		repo.deleteById(id);
		
		Optional<Brand> result = repo.findById(id);
		
		assertThat(result.isEmpty());
	}
}

	