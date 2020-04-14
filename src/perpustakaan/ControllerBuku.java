package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ControllerBuku extends JFrame
{
    ViewBuku viewBuku;
    ModelPerpustakaan modelPerpustakaan;
    
    public ControllerBuku( ViewBuku viewBuku, ModelPerpustakaan modelPerpustakaan)
    {
        this.viewBuku = viewBuku;
        this.modelPerpustakaan = modelPerpustakaan;
        
        
        if(modelPerpustakaan.getBanyakDataBuku() != 0)
        {
         String dataBuku[][] = modelPerpustakaan.readBuku();
         viewBuku.tabel.setModel((new JTable(dataBuku, viewBuku.namaKolom)).getModel());
        }
        else 
        {
         JOptionPane.showMessageDialog(null, "Data Not Found");
        }
               
        viewBuku.btnSimpan.addActionListener((ActionEvent e)->
        {
           
           String kode = viewBuku.getKode();
           String judul = viewBuku.getJudul();
           String pengarang = viewBuku.getPengarang();
           String penerbit = viewBuku.getPenerbit();
           String tahun = viewBuku.getTahun();
           
           modelPerpustakaan.insertBuku(kode, judul, pengarang, penerbit, tahun);

           String dataBuku[][] = modelPerpustakaan.readBuku();
           viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
        });
        
        viewBuku.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = viewBuku.tabel.getSelectedRow();
                int kolom = viewBuku.tabel.getSelectedColumn();
                
                String dataterpilih = viewBuku.tabel.getValueAt(baris, 0).toString();
                
                
                System.out.println(dataterpilih);
                
            viewBuku.btnHapus.addActionListener((ActionEvent x)->
            {
                modelPerpustakaan.deleteBuku(dataterpilih);
                String dataBuku[][] = modelPerpustakaan.readBuku();
                viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
            });
            }
                    
        });
        
        viewBuku.btnRefresh.addActionListener((ActionEvent e)->
        {
            viewBuku.tfkodeBuku.setText("");
            viewBuku.tfjudulBuku.setText("");
            viewBuku.tfnamaPengarang.setText("");
            viewBuku.tfnamaPenerbit.setText("");
            viewBuku.tftahunTerbit.setText("");
           String dataBuku[][] = modelPerpustakaan.readBuku();
           viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
        });    
        
        viewBuku.btnKeluar.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ViewAwal awal = new ViewAwal();
                viewBuku.dispose();
            }
        });  
        
        viewBuku.btnCari.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String search = viewBuku.getKode();
                String dataBuku[][] = modelPerpustakaan.searchBuku(search);
                viewBuku.tabel.setModel(new JTable (dataBuku, viewBuku.namaKolom).getModel());
            }
        });
        
        
    }
}
