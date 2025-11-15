package in.umangcraft.moneymanager.repository;

import in.umangcraft.moneymanager.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    //select * from tbl_profiles where email = ?1
    Optional<ProfileEntity> findByEmail(String email);

    //select * from tbl_profiles where activation_token = ?1
    Optional<ProfileEntity> findByActivationToken(String activationToken);
}
