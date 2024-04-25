package com.Bank;

import com.Bank.entity.Role;
import com.Bank.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
	@Autowired
	RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();
	}


	@Override
	public void run(String... args) throws Exception {
		try{
			Role role=new Role();
			role.setId(1);
			role.setName("ROLE_ADMIN");
			Role role1=new Role();
			role1.setId(2);
			role1.setName("ROLE_NORMAL");
			List<Role> roles = List.of(role, role1);
			List<Role> result = this.roleRepo.saveAll(roles);
			result.forEach(r->{
				System.out.println(r.getName());
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
