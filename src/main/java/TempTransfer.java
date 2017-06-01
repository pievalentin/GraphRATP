/**
 * Created by Pierre Valentin on 30/05/2017.
 */
public class TempTransfer {
    protected int idSation1;
    protected int idStation2;

    public int getIdStation1() {
        return idSation1;
    }

    public void setIdSation1(int idSation1) {
        this.idSation1 = idSation1;
    }

    public int getIdStation2() {
        return idStation2;
    }

    public void setIdStation2(int idStation2) {
        this.idStation2 = idStation2;
    }

    public TempTransfer(int idSation1, int idStation2) {
        this.idSation1 = idSation1;
        this.idStation2 = idStation2;
    }
}
