import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DsChiTietPNH {
    private int n;
    private ChiTietPNH[] dsdetailPNH;

    public DsChiTietPNH() {}

    public DsChiTietPNH(int n) {
        this.dsdetailPNH = new ChiTietPNH[n];
        this.n = n;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong chi tiet phieu nhap hang: ");
        n = sc.nextInt();

        dsdetailPNH = new ChiTietPNH[n];

        for(int i = 0; i < n;i++){
            System.out.println("Nhap thong tin chi tiet phieu nhap hang " +(i + 1));
            dsdetailPNH[i] = new ChiTietPNH();
            dsdetailPNH[i].nhap();

        }
    }

    public void xuat(){
        System.out.println("===============DANH SACH CHI TIET PHIEU NHAP HANG===========");
        for(int i = 0;i < n;i++){
            dsdetailPNH[i].xuat();
        }
    }

    public void themdetailpnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin chi tiet phieu nhap hang can them: ");
        n = dsdetailPNH.length;
        dsdetailPNH = Arrays.copyOf(dsdetailPNH, n + 1);
        dsdetailPNH[n] = new ChiTietPNH();
        dsdetailPNH[n].nhap();
        n++;
    }

    public void themdetailpnh(ChiTietPNH x){
        n = dsdetailPNH.length;
        dsdetailPNH = Arrays.copyOf(dsdetailPNH, n + 1);
        dsdetailPNH[n] = new ChiTietPNH(x);
        n++;
    }

    public void suamapnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chi tiet phieu nhap hang can sua thong tin: ");
        String masua = sc.nextLine();

        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(masua)){
                System.out.println("Nhap thong tin moi: ");
                dsdetailPNH[i].nhap();
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma " + masua +"cua chi tiet phieu nhap hang");
        }
    }

    public void suamapnh(ChiTietPNH mapnh){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(mapnh.getMapnh())){
                System.out.println("Nhap thong tin can sua cho ma " + mapnh);
                dsdetailPNH[i].nhap();
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma " + mapnh);
        }
    }
    
    public void xoapnhtheoma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chi tiet phieu nhap hang muon xoa: ");
        String maxoa = sc.nextLine();

        boolean timthay = false;

        for(int i = 0; i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(maxoa)){
                for(int j = i; j < n - 1; j++){
                    dsdetailPNH[j] = dsdetailPNH[j + 1];
                }

                n--;
                dsdetailPNH = Arrays.copyOf(dsdetailPNH, n);
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma " + maxoa +"cua chi tiet phieu nhap hang.");
        }

    }
    
    public void xoapnhtheoma(ChiTietPNH mapnh){
        boolean timthay = false;

        for(int i = 0; i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(mapnh.getMapnh())){
                for(int j = i; j < n - 1; j++){
                    dsdetailPNH[j] = dsdetailPNH[j + 1];
                }

                n--;
                dsdetailPNH = Arrays.copyOf(dsdetailPNH, n);
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma " + mapnh +"cua chi tiet phieu nhap hang.");
        }
    }

    public ChiTietPNH timtheomapnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chi tiet phieu nhap hang: ");
        String timma = sc.nextLine();

        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(timma)){
                return dsdetailPNH[i];
            }
        }
        return null;
    }

    public ChiTietPNH timtheomapnh(ChiTietPNH mapnh){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ma chi tiet phieu nhap hang: " + mapnh);

        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMapnh().equals(mapnh.getMapnh())){
                return dsdetailPNH[i];
            }
        }
        return null;
    }

    public ChiTietPNH timtheomasp(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap ma san pham: " );
        String timten = sc.nextLine();
        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMasp().equals(timten)){
                return dsdetailPNH[i];
            }
        }
        return null;
    }

    public ChiTietPNH timtheomasp(ChiTietPNH masp){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ma nha cung cap " + masp);

        for(int i = 0;i < n;i++){
            if(dsdetailPNH[i].getMasp().equals(masp.getMasp())){
                return dsdetailPNH[i];
            }
        }
        return null;
    }

    public void thongke(){
        long tong = 0;
        for(int i = 0; i < n; i++){
            tong += dsdetailPNH[i].getThanhtien();
        }
        System.out.println("Tong gia tri nhap hang cua tat ca chi tiet: " + tong + " VND");
    }

       public void ghiFile() throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("ChiTietPNH.txt"))) {
        for (int i = 0; i < n; i++) {
            // Mỗi dòng là 1 phiếu nhập, cách nhau bằng dấu phẩy
            bw.write(dsdetailPNH[i].getMapnh() + "," +
                     dsdetailPNH[i].getMasp() + "," +
                     dsdetailPNH[i].getSoluong() + "," +
                     dsdetailPNH[i].getDongia());
            bw.newLine();
        }
        System.out.println("Ghi file thành công!");
    } catch (IOException e) {
        System.out.println("Lỗi ghi file: " + e.getMessage());
    }
}

public void docFile() {
    try (BufferedReader br = new BufferedReader(new FileReader("ChiTietPNH.txt"))) {
        String line;
        n = 0;
        dsdetailPNH = new ChiTietPNH[100]; // cấp phát tạm 100 phần tử

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String mapnh = parts[0];
                String masp = parts[1];
                int soluong = Integer.parseInt(parts[2]);
                long dongia = Long.parseLong(parts[3]);

                dsdetailPNH[n] = new ChiTietPNH(mapnh, masp, soluong, dongia);
                n++;
            }
        }

        dsdetailPNH = Arrays.copyOf(dsdetailPNH, n); // cắt đúng kích thước mảng
        System.out.println("Đọc file thành công! Có " + n + " phiếu nhập hàng.");
    } catch (IOException e) {
        System.out.println("Lỗi đọc file: " + e.getMessage());
    }
}


}
