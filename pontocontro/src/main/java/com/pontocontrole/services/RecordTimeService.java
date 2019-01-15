package com.pontocontrole.services;

import com.pontocontrole.domain.RecordTime;
import com.pontocontrole.domain.enums.DayOfWeekEnum;
import com.pontocontrole.dto.RecordTimeDTO;
import com.pontocontrole.repositories.RecordTimeRepository;
import com.pontocontrole.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordTimeService {

    @Autowired
   private RecordTimeRepository recordTimeRepository;

    public RecordTime find(Integer id){
        Optional<RecordTime> obj = recordTimeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + RecordTime.class.getName()));
    }

    public RecordTime insert(RecordTime obj) {
        obj.setId(null);
        return recordTimeRepository.save(obj);
    }





    public RecordTime fromDTO(RecordTimeDTO objDTO){
        return new RecordTime(null, null, null, null,  objDTO.getEmployee());

    }



}
