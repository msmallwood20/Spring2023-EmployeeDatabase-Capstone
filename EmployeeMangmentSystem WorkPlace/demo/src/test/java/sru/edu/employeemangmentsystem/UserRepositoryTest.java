package sru.edu.employeemangmentsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.annotation.Rollback;

import edu.sru.walters.EmployeeManagementSystem.models.Users;
import edu.sru.walters.EmployeeManagementSystem.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser()
	{
		Users user = new Users();
		user.setEmail("mns1013@sru.edu");
		user.setPassword("password");
		user.setFirstName("Maya");
		user.setLastName("Smallwood");
		
		Users savedUser = repo.save(user);
		
		Users existUser = entityManager.find(Users.class, savedUser.getId());
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
