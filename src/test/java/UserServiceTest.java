import com.k15t.pat.builders.UserBuilder;
import com.k15t.pat.pojos.User;
import com.k15t.pat.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    //TODO: ADD Tests for UserService, UserRestController, UserController
    private TestEntityManager entityManager;


    private UserService userService;

    public UserServiceTest () {
    }

    @Test
    public void whenFindById () {

        User alex = new UserBuilder().email("tomi.lekar@outlook.de")
                .name("Tomi").number("1231331").password("test").build();
        User dbUser = entityManager.persist(alex);
        entityManager.flush();

        // when
        User found = userService.findOne(dbUser.getId());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());

    }
}
