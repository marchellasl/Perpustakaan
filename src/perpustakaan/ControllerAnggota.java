package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ControllerAnggota extends JFrame{
    ViewAnggota viewAnggota;
    ModelPerpustakaan modelPerpustakaan;
    
    public ControllerAnggota(ViewAnggota viewAnggota, ModelPerpustakaan modelPerpustakaan)
    {
        this.viewAnggota = viewAnggota;
        this.modelPerpustakaan = modelPerpustakaan;
        
        if(modelPerpustakaan.getBanyakDataAnggota() != 0)
        {
         String dataAnggota[][] = modelPerpustakaan.readAnggota();
         viewAnggota.tabel.setModel((new JTable(dataAnggota, viewAnggota.namaKolom)).getModel());
        }
        else 
        {
         JOptionPane.showMessageDialog(null, "Data Not Found");
        }
        
        viewAnggota.btnSimpan.addActionListener((ActionEvent e)->
        {
           
           String nis = viewAnggota.getNis();
           String nama = viewAnggota.getNama();
           String tglLahir = viewAnggota.getTanggalLahir();
           String jk = viewAnggota.getJk();
           String agama = viewAnggota.getAgama();
           String kelas = viewAnggota.getKelas();
           String tglDaftar = viewAnggota.getTglDaftar();
           String berlakuHingga = viewAnggota.getBerlakuHingga();
           
           modelPerpustakaan.insertAnggota(nis, nama, tglLahir, jk, agama, kelas, tglDaftar, berlakuHingga);

           String dataAnggota[][] = modelPerpustakaan.readAnggota();
           viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
        });
        
        viewAnggota.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = viewAnggota.tabel.getSelectedRow();
                int kolom = viewAnggota.tabel.getSelectedColumn();
                
                String dataterpilih = viewAnggota.tabel.getValueAt(baris, 0).toString();
                
                
                System.out.println(dataterpilih);
                
            viewAnggota.btnHapus.addActionListener((ActionEvent x)->
            {
                modelPerpustakaan.deleteAnggota(dataterpilih);
                String dataAnggota[][] = modelPerpustakaan.readAnggota();
                viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
            });
            }
                    
        });
        
        viewAnggota.btnRefresh.addActionListener((ActionEvent e)->
        {
            viewAnggota.tfnis.setText("");
            viewAnggota.tfnamaAnggota.setText("");
            viewAnggota.tftanggalLahir.setText("");
            viewAnggota.cmbagama.setSelectedItem("");
            viewAnggota.tfkelas.setText("");
            viewAnggota.tftanggalDaftar.setText("");
            viewAnggota.tftanggalAkhir.setText("");
            
           String dataAnggota[][] = modelPerpustakaan.readAnggota();
           viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
        }); 
        
        viewAnggota.btnKeluar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ViewAwal awal = new ViewAwal();
                viewAnggota.dispose();
            }
        });  
        
        
    }
 
}

       
