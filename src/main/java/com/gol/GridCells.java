package com.gol;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.Collection;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

public class GridCells extends ArrayList<Cell> {

    public GridCells(Cell... cells) {
        this.addAll(newArrayList(cells));
    }

    public GridCells(Collection<Cell> cells) {
        this.addAll(cells);
    }

    static GridCells from_string(int rowIndex, String cells_as_string) {
        GridCells grid_row = new GridCells();
        char[] cell_chars = cells_as_string.toCharArray();
        for (int cell_size = cell_chars.length, columnIndex = 0; columnIndex < cell_size; columnIndex++) {
            Cell cell = Cell.from_string(rowIndex, columnIndex, cell_chars[columnIndex]);
            grid_row.add(cell);
        }
        return grid_row;
    }



    public String state() {
        return on("").join(transform(this, new Function<Cell, String>() {
            public String apply(Cell cell) {
                return cell.state().toString();
            }
        }));
    }

    public int count() {
        return size();
    }

    GridCells filter_by(Predicate<Cell> predicate) {
        return new GridCells(filter(this, predicate));
    }

    GridCells live_cells() {
        return filter_by(Cell.IS_LIVE);
    }
}
