package com.builderssas.api.mapper.material;

import com.builderssas.api.domain.model.material.MaterialsStock;
import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T09:43:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class MaterialsStockMapperImpl implements MaterialsStockMapper {

    @Override
    public MaterialsStockDto toDto(MaterialsStock stock) {
        if ( stock == null ) {
            return null;
        }

        MaterialsStockDto materialsStockDto = new MaterialsStockDto();

        return materialsStockDto;
    }

    @Override
    public MaterialsStock toEntity(CreateMaterialsStockDto dto) {
        if ( dto == null ) {
            return null;
        }

        MaterialsStock materialsStock = new MaterialsStock();

        return materialsStock;
    }

    @Override
    public void updateEntityFromDto(UpdateMaterialsStockDto dto, MaterialsStock stock) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<MaterialsStockDto> toDtos(List<MaterialsStock> stocks) {
        if ( stocks == null ) {
            return null;
        }

        List<MaterialsStockDto> list = new ArrayList<MaterialsStockDto>( stocks.size() );
        for ( MaterialsStock materialsStock : stocks ) {
            list.add( toDto( materialsStock ) );
        }

        return list;
    }

    @Override
    public Set<MaterialsStockDto> toDtoSet(Set<MaterialsStock> stocks) {
        if ( stocks == null ) {
            return null;
        }

        Set<MaterialsStockDto> set = new LinkedHashSet<MaterialsStockDto>( Math.max( (int) ( stocks.size() / .75f ) + 1, 16 ) );
        for ( MaterialsStock materialsStock : stocks ) {
            set.add( toDto( materialsStock ) );
        }

        return set;
    }
}
