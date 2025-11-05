import java.io.IOException;
import java.util.Scanner;

public class QLPNH extends QLBH {

    public QLPNH() {
        super();
    }

    @Override
    public void menuChinh() throws IOException {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== MENU QUAN LY PHIEU NHAP HANG ==========");
            System.out.println("1. Xem danh sach phieu nhap hang");
            System.out.println("2. Them phieu nhap hang");
            System.out.println("3. Sua phieu nhap hang");
            System.out.println("4. Xoa phieu nhap hang");
            System.out.println("5. Tim kiem phieu nhap hang");
            System.out.println("6. Thong ke theo nam");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            chon = sc.nextInt();
            sc.nextLine(); // bo \n

            switch (chon) {
                case 1:
                    dspnh.xuat();
                    break;
                case 2:
                    dspnh.thempnh();
                    break;
                case 3:
                    dspnh.suamapnh();
                    break;
                case 4:
                    dspnh.xoapnh();
                    break;
                case 5:
                    PhieuNhapHang p = dspnh.timpnh();
                    if (p != null) p.xuat();
                    else System.out.println("Khong tim thay phieu nhap hang.");
                    break;
                case 6:
                    System.out.print("Nhap nam can thong ke: ");
                    int nam = sc.nextInt();
                    int soLuong = dspnh.thongkeTheoNam(nam);
                    System.out.println("So phieu nhap hang trong nam " + nam + " la: " + soLuong);
                    break;
                case 0:
                    System.out.println("Thoat menu QLPNH...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
