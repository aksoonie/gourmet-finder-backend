package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.CreateCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.DeleteCulinaryEventCommand;

public interface CulinaryEventCommandService {
    Long handle(CreateCulinaryEventCommand command);
    void handle (DeleteCulinaryEventCommand command);
}
