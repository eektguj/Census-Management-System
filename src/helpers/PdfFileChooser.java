/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.CUSTOM_DIALOG;
import static javax.swing.JFileChooser.SAVE_DIALOG;

/**
 *
 * @author amir
 */
public class PdfFileChooser extends JFileChooser{
    private static final long serialVersionUID = 1L;
    private String extension;

    public PdfFileChooser(String currentDirectoryPath, String extension)
    {
        super(currentDirectoryPath);
        this.extension = extension;
    }

    @Override
    public File getSelectedFile()
    {
        File selectedFile = super.getSelectedFile();
        if(selectedFile != null && (getDialogType() == SAVE_DIALOG || getDialogType() == CUSTOM_DIALOG))
        {
            String name = selectedFile.getName();
            if(!name.contains(".")) selectedFile = new File(selectedFile.getParentFile(), name + "." + extension);
        }
        return selectedFile;
    }
}
