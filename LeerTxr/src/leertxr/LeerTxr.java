/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leertxr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jc-olguins
 */
public class LeerTxr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LeerTxr abrir = new LeerTxr();
        System.out.println(abrir.abrirArchivo());
abrir.guardarArchivo();
    }

    private void guardarArchivo() {
        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(null);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + ".txt");
//                save.write(areaDeTexto.getText());
                save.write("hola");
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String abrirArchivo() {
        String aux = "";
        String texto = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            /**
             * abrimos el archivo seleccionado
             */
            File abre = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    texto += aux + "\n";
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;//El texto se almacena en el JTextArea
    }
}
