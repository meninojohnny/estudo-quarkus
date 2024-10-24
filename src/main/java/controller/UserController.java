/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.UserEntity;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import service.UserService;

/**
 *
 * @author joaovitor
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        List<UserEntity> users = userService.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        return Response.ok(userService.createUser(userEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(userService.findById(id)).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserEntity userEntity) {
        return Response.ok(userService.updateUser(id, userEntity)).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        userService.deleteById(id);
        return Response.ok("Deletado com sucesso!").build();
    }

}

