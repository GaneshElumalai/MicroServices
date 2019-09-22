package user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	public User findByUserName(String userName);
}
