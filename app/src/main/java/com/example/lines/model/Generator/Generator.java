package com.example.lines.model.Generator;

import com.example.lines.model.Color;
import com.example.lines.model.utils.Position;

import java.util.List;

public interface Generator {
    List<Color> generateNextColors();
    List<Position> choosePositions(List<Position> freePositions);
}