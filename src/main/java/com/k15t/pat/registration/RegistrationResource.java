package com.k15t.pat.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.k15t.pat.pojos.User;
import com.k15t.pat.repositorys.UserRepository_deprecated;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;


@CrossOrigin
@Path("/registration")
@Component
public class RegistrationResource {

    // Extend the current resource to receive and store the data in memory.
    // Return a success information to the user including the entered information.
    // In case of the address split the information into a better format/structure
    // for better handling later on.

    private final UserRepository_deprecated userRepositoryDeprecated;
    String MESSAGE = "";

    public RegistrationResource (UserRepository_deprecated userRepositoryDeprecated) {
        this.userRepositoryDeprecated = userRepositoryDeprecated;
    }

    // Could use Spring....
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response save (@FormParam("name") String name, @FormParam("password") String password,
                          @FormParam("email") String email, @FormParam("number") String number) throws Exception {
        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || number.isEmpty()) {
            this.MESSAGE = "Form is Invalid!!";
            return Response.serverError().status(500).build().temporaryRedirect(URI.create("../registration.html")).build();

        }
        User user = new User(name, email, password, number);
        userRepositoryDeprecated.saveUser(user);
        this.MESSAGE = userRepositoryDeprecated.MESSAGE;
        return Response.temporaryRedirect(URI.create("../createduser.html")).header("Access-Control-Allow-Origin", "*").build();
        //return objectWriter.writeValueAsString(user);
    }

    @GET()
    @Path("/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser (@PathParam("mail") String email) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer();
        if (email.isEmpty()) return objectWriter.writeValueAsString(null);
        Optional<User> user = this.userRepositoryDeprecated.getUserInformationByEmail(email);
        if (user.isPresent()) return objectWriter.writeValueAsString(user.get());
        return objectMapper.writeValueAsString(null);

    }

    public UserRepository_deprecated getUserRepositoryDeprecated () {
        return userRepositoryDeprecated;
    }

}
