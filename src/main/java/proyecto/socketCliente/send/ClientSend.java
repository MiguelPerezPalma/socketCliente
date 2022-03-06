package proyecto.socketCliente.send;

import java.io.Serializable;

public class ClientSend {
	protected int select;
    protected Object obj1;
    protected Object obj2;
    protected boolean comprobante;
	public ClientSend(Object obj1, Object obj2, boolean comprobante) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.comprobante = comprobante;
	}
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public Object getObj1() {
		return obj1;
	}
	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}
	public Object getObj2() {
		return obj2;
	}
	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}
	public boolean isComprobante() {
		return comprobante;
	}
	public void setComprobante(boolean comprobante) {
		this.comprobante = comprobante;
	}
    
    
}
