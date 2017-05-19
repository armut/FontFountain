package main;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * zamma on 20.05.2017.
 */
public class FontFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if(file.isDirectory())
            return true;

        String extension = getExtension(file);
        if(extension != null) {
            if(extension.equals("ttf"))
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "TrueType Font Files (*.ttf)";
    }

    private String getExtension(File f) {
        String extension = null;
        String fileName = f.getName();
        int dot = fileName.lastIndexOf('.');
        if(dot > 0 && dot < fileName.length() - 1)
            extension = fileName.substring(dot + 1).toLowerCase();
        return extension;
    }
}
