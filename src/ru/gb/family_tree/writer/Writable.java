package ru.gb.family_tree.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writable{
    void save(Serializable serializable, String filePath) throws IOException;
    Object read(String filePath);
}
