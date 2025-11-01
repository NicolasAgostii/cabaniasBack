package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.MesDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.services.MesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/meses")
@RequiredArgsConstructor
public class MesController {
    private final MesService mesService;

    @GetMapping
    public List<MesDTO> all() {
        return mesService.findAll();
    }

    @GetMapping("/{id}")
    public MesDTO byId(@PathVariable Long id) {
        return mesService.findById(id);
    }

    @PostMapping
    public MesDTO create(@RequestBody MesDTO dto) {
        return mesService.create(dto);
    }
}
