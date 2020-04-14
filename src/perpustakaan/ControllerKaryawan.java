package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.awt.resources.awt;

public class ControllerKaryawan {
    ViewKaryawan viewKaryawan;
    ModelPerpustakaan modelPerpustakaan;
    
    public ControllerKaryawan(ViewKaryawan viewKaryawan, ModelPerpustakaan modelPerpustakaan)
    {
        
        this.viewKaryawan = viewKaryawan;
        this.modelPerpustakaan = modelPerpustakaan;
        
        if(modelPerpustakaan.getBanyakDataKaryawan() != 0)
        {
         String dataKaryawan[][] = modelPerpustakaan.readKaryawan();
         viewKaryawan.tabel.setModel((new JTable(dataKaryawan, viewKaryawan.namaKolom)).getModel());
        }
        else 
        {
         JOptionPane.showMessageDialog(null, "Data Not Found");
        }
        
        viewKaryawan.btnSimpan.addActionListener((ActionEvent e)->
        {
           
           String nik = viewKaryawan.getNik();
           String nama = viewKaryawan.getNama();
           String jk = viewKaryawan.getJk();
           String golongan = viewKaryawan.getGolongan();
           
           modelPerpustakaan.insertKaryawan(nik, nama, jk, golongan);
           String dataKaryawan[][] = modelPerpustakaan.readKaryawan();
           viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
        });
        
        viewKaryawan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = viewKaryawan.tabel.getSelectedRow();
                int kolom = viewKaryawan.tabel.getSelectedColumn();
                
                String dataterpilih = viewKaryawan.tabel.getValueAt(baris, 0).toString();
                
                
                System.out.println(dataterpilih);
                
            viewKaryawan.btnHapus.addActionListener((ActionEvent x)->
            {
                modelPerpustakaan.deleteKaryawan(dataterpilih);
                String dataKaryawan[][] = modelPerpustakaan.readKaryawan();
                viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
            });
            }
                    
        });
        
        viewKaryawan.btnRefresh.addActionListener((ActionEvent e)->
        {
            viewKaryawan.tfnik.setText("");
            viewKaryawan.tfnamaKaryawan.setText("");
            viewKaryawan.tfgolongan.setText("");
            viewKaryawan.tfjabatan.setText("");
            viewKaryawan.tftunjangan.setText("");
            viewKaryawan.tfjumlahGaji.setText("");            

            String dataKaryawan[][] = modelPerpustakaan.readKaryawan();
            viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
        });  
        
        viewKaryawan.btnKeluar.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ViewAwal awal = new ViewAwal();
                viewKaryawan.dispose();
            }
        });
        
        viewKaryawan.tfgolongan.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                 if (e.getKeyCode()==KeyEvent.VK_ENTER)
                 {
                     if("1".equals(viewKaryawan.getGolongan()))
                     {
                         viewKaryawan.tfjabatan.setText("Manager");
                         viewKaryawan.tftunjangan.setText("700000");
                         viewKaryawan.tfjumlahGaji.setText("10000000");
                     }
                     else if("2".equals(viewKaryawan.getGolongan()))
                     {
                         viewKaryawan.tfjabatan.setText("Supervisor");
                         viewKaryawan.tftunjangan.setText("300000");
                         viewKaryawan.tfjumlahGaji.setText("5000000");
                     }
                     else if("3".equals(viewKaryawan.getGolongan()))
                     {
                         viewKaryawan.tfjabatan.setText("Staff");
                         viewKaryawan.tftunjangan.setText("400000");
                         viewKaryawan.tfjumlahGaji.setText("3000000");
                     }
                     else if("4".equals(viewKaryawan.getGolongan()))
                     {
                         viewKaryawan.tfjabatan.setText("Ass. Staff");
                         viewKaryawan.tftunjangan.setText("300000");
                         viewKaryawan.tfjumlahGaji.setText("2000000");
                     }
                     else if("5".equals(viewKaryawan.getGolongan()))
                     {
                         viewKaryawan.tfjabatan.setText("Honorer");
                         viewKaryawan.tftunjangan.setText("200000");
                         viewKaryawan.tfjumlahGaji.setText("1000000");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null, "Hanya dapat input golongan 1-5");
                         viewKaryawan.tfgolongan.setText("");
                         viewKaryawan.tfjabatan.setText("");
                         viewKaryawan.tftunjangan.setText("");
                         viewKaryawan.tfjumlahGaji.setText("");
                     }
                 }   
            }
        });
        
        viewKaryawan.btnCari.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String search = viewKaryawan.getNik();
                String dataKaryawan[][] = modelPerpustakaan.searchKaryawan(search);
                viewKaryawan.tabel.setModel(new JTable (dataKaryawan, viewKaryawan.namaKolom).getModel());
            }
        });
    }

}
