-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Apr 2020 pada 23.52
-- Versi server: 5.0.45-community-nt
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `NIS` int(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `ttl` date NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `tanggal_daftar` date NOT NULL,
  `berlaku_hingga` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`NIS`, `nama`, `ttl`, `jenis_kelamin`, `agama`, `kelas`, `tanggal_daftar`, `berlaku_hingga`) VALUES
(123170138, 'Reyhan', '1997-04-16', 'Laki-Laki', 'Islam', 'E', '2019-08-12', '2020-08-12'),
(123180001, 'Syifa', '2000-09-02', 'Perempuan', 'Buddha', 'A', '2020-03-02', '2021-03-02'),
(123180133, 'Chella', '2002-03-31', 'Perempuan', 'Islam', 'D', '2020-03-02', '2022-03-02');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kode_buku` int(4) NOT NULL,
  `judul_buku` varchar(50) NOT NULL,
  `nama_pengarang` varchar(50) NOT NULL,
  `nama_penerbit` varchar(50) NOT NULL,
  `tahun_terbit` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kode_buku`, `judul_buku`, `nama_pengarang`, `nama_penerbit`, `tahun_terbit`) VALUES
(1433, 'Modul PBO', 'Pak Novrido', 'UPN', 2020),
(1901, 'Amor Fati', 'RKim', 'Gramedia', 2017),
(1997, 'IQ48', 'Haruki Murakami', 'Gramedia', 2014);

-- --------------------------------------------------------

--
-- Struktur dari tabel `golongan`
--

CREATE TABLE `golongan` (
  `golongan` int(1) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `tunjangan` int(200) NOT NULL,
  `jumlah_gaji` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `golongan`
--

INSERT INTO `golongan` (`golongan`, `jabatan`, `tunjangan`, `jumlah_gaji`) VALUES
(1, 'Manager', 700000, 10000000),
(2, 'Supervisor', 300000, 5000000),
(3, 'Staff', 400000, 3000000),
(4, 'Ass Staff', 300000, 2000000),
(5, 'Honorer', 200000, 1000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` int(9) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `golongan` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`NIK`, `nama_karyawan`, `jenis_kelamin`, `golongan`) VALUES
(111222333, 'Fadhli', 'Laki-Laki', 2),
(111222334, 'Laras', 'Perempuan', 1),
(111222336, 'Dika', 'Laki-Laki', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `no_pinjam` int(4) NOT NULL,
  `NIS` int(9) NOT NULL,
  `kode_buku` int(4) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `lama_pinjam` int(10) NOT NULL,
  `denda` int(200) NOT NULL,
  `NIK` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`no_pinjam`, `NIS`, `kode_buku`, `tanggal_pinjam`, `tanggal_kembali`, `lama_pinjam`, `denda`, `NIK`) VALUES
(1002, 123170138, 1901, '2020-04-19', '2020-04-20', 1, 0, 111222334),
(1003, 123180133, 1997, '2020-04-02', '2020-04-22', 20, 13000, 111222336);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`NIS`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indeks untuk tabel `golongan`
--
ALTER TABLE `golongan`
  ADD PRIMARY KEY (`golongan`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`NIK`),
  ADD KEY `golongan` (`golongan`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`no_pinjam`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `NIS` (`NIS`),
  ADD KEY `NIK` (`NIK`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_ibfk_1` FOREIGN KEY (`golongan`) REFERENCES `golongan` (`golongan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`NIS`) REFERENCES `anggota` (`NIS`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`NIK`) REFERENCES `karyawan` (`NIK`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
