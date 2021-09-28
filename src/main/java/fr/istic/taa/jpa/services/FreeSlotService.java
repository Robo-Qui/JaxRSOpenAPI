package fr.istic.taa.jpa.services;

import fr.istic.taa.jpa.business.FreeSlot;
import fr.istic.taa.jpa.dao.FreeSlotManager;

import java.util.List;

public class FreeSlotService {
    private FreeSlotManager manager;

    public FreeSlotService(FreeSlotManager manager) {
        this.manager = manager;
    }

    public List<FreeSlot> add(FreeSlot slot, List<FreeSlot> slots){
        for (FreeSlot sl : slots){
            //si chevauchement
            if(slot.getStartTime().after(sl.getStartTime())&&slot.getStartTime().before(sl.getEndTime()) ||
                    slot.getEndTime().before(sl.getEndTime()) && slot.getEndTime().after(sl.getStartTime())){
                return slots;
            }
        }
        manager.save(slot);
        slots.add(slot);
        return slots;
    }

    public List<FreeSlot> remove(List<FreeSlot> slots, FreeSlot slot){
        slots.remove(slot);
        return slots;
    }
}
