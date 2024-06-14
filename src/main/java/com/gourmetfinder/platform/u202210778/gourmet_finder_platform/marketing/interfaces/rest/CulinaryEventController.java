package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.DeleteCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetAllCulinaryEventsQuery;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetCulinaryEventByIdQuery;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services.CulinaryEventCommandService;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services.CulinaryEventQueryService;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.resources.CreateCulinaryEventResource;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.resources.CulinaryEventResource;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.transform.CreateCulinaryEventCommandFromResourceAssembler;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.transform.CulinaryEventResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/culinary-events", produces = APPLICATION_JSON_VALUE)
public class CulinaryEventController {
    private final CulinaryEventCommandService culinaryEventCommandService;
    private final CulinaryEventQueryService culinaryEventQueryService;

    CulinaryEventController(CulinaryEventCommandService culinaryEventCommandService, CulinaryEventQueryService culinaryEventQueryService) {
        this.culinaryEventCommandService = culinaryEventCommandService;
        this.culinaryEventQueryService = culinaryEventQueryService;
    }
    //POST
    /**
     * Crea un evento culinario
     * @param createCulinaryEventResource CreateCulinaryEventResource
     * @return CulinaryEventResource and the status HTTP CREATED
     * @author Jimena Cama
     */
    @PostMapping
    public ResponseEntity<CulinaryEventResource> createCulinaryEvent(@RequestBody CreateCulinaryEventResource createCulinaryEventResource) {
        var createCulinaryEventCommand = CreateCulinaryEventCommandFromResourceAssembler.toCommandFromResource(createCulinaryEventResource);
        var culinaryEventId = culinaryEventCommandService.handle(createCulinaryEventCommand);
        if (culinaryEventId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getCulinaryEventByIdQuery = new GetCulinaryEventByIdQuery(culinaryEventId);
        var culinaryEvent= culinaryEventQueryService.handle(getCulinaryEventByIdQuery);
        if (culinaryEvent.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var culinaryEventResource= CulinaryEventResourceFromEntityAssembler.toResourceFromEntity(culinaryEvent.get());
                return new ResponseEntity<>(culinaryEventResource, HttpStatus.CREATED);
   }
   //GETTER
    @GetMapping({"/{culinaryEventId}"})
    public ResponseEntity<CulinaryEventResource> getCulinaryEventById(@PathVariable Long culinaryEventId) {
        var getCulinaryEventByIdQuery = new GetCulinaryEventByIdQuery(culinaryEventId);
        var culinaryEvent = culinaryEventQueryService.handle(getCulinaryEventByIdQuery);
        if (culinaryEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var culinaryEventResource = CulinaryEventResourceFromEntityAssembler.toResourceFromEntity(culinaryEvent.get());
        return ResponseEntity.ok(culinaryEventResource);
    }
    @GetMapping
    public ResponseEntity<List<CulinaryEventResource>> getAllCulinaryEvents(){
        var getAllCulinaryEventsQuery = new GetAllCulinaryEventsQuery();
        var culinaryEvents = culinaryEventQueryService.handle(getAllCulinaryEventsQuery);
        var culinaryEventResources = culinaryEvents.stream().map(CulinaryEventResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(culinaryEventResources);
    }
    @DeleteMapping({"/{culinaryEventId}"})
    public ResponseEntity<?> deleteCulinaryEvent(@PathVariable Long culinaryEventId){
        var deleteCulinaryEventCommand = new DeleteCulinaryEventCommand(culinaryEventId);
        culinaryEventCommandService.handle(deleteCulinaryEventCommand);
        return ResponseEntity.ok("Culinary Event Deleted Successfully!");
    }


}
