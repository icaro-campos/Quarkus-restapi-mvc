package br.com.api;

import br.com.api.dto.StateDTO;
import br.com.api.service.StateService;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/states")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StateResource {

    @Inject
    StateService stateService;

    @GET
    public List<StateDTO> findPages (
            @DefaultValue("0") @QueryParam(value = "page") Integer page,
            @DefaultValue("12") @QueryParam(value = "rowPage") Integer rowPage)
    {
        Page pageRequest = new Page(page,rowPage);
        return stateService.findPages(pageRequest);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Long registers(){
        return stateService.registers();

    }

    @POST
    public Response insert (@Valid StateDTO dto){
        stateService.insert(dto);
        return Response.status(Response.Status.CREATED).build();

    }

    @PUT
    @Path("{id}")
    public StateDTO update (@PathParam("id") Long id, @Valid StateDTO dto){
        return stateService.update(id, dto);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        stateService.delete(id);
        return Response.noContent().build();

    }



}
