import javax.swing.*;
import java.awt.*;
import java.io.*;

    public class OpenFile {
        public static void abrirArquivo() {
            try {
                JFileChooser chooser = new JFileChooser();

                chooser.setDialogTitle("Selecione o arquivo que ");
                chooser.setApproveButtonText("Abrir arquivo");

                int returnVal1 = chooser.showOpenDialog( null);
                String fileFullPath = "";
                if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                    fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {

                System.out.println("Que pena!");
            }

            try {
                File file = new File(fileFullPath);
                if(!Desktop.isDesktopSupported()) {
                    System.err.println("Desktop is not supported in this machine");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.open(file);
                }            
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Arquivo aberto com sucesso");    
        } catch (Exception e) {
            System.err.println("Não foi possivel abrir o arquivo.");
        }

    }
}
