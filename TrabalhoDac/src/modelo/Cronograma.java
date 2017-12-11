package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cronograma")
public class Cronograma {
	
	@Id
	@Column(name="id_cronograma")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCronograma;
	
	@Column(name="dataDefesa")
	private Date dataDefesa;

	@Column(name="registrado")
	private Date registrado;
	
	@OneToOne(mappedBy="cronograma")
	private Projeto projeto;
	
	/*@Column(name="dataEntregasParciais")
	private List<Date> dataEntregasParciais;*/

	public int getId() {
		return idCronograma;
	}

	public void setId(int idCronograma) {
		this.idCronograma = idCronograma;
	}

	public Date getDataDefesa() {
		return dataDefesa;
	}

	public void setDataDefesa(Date dataDefesa) {
		this.dataDefesa = dataDefesa;
	}

	public Date getRegistrado() {
		return registrado;
	}

	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}

	/*public List<Date> getDataEntregasParciais() {
		return dataEntregasParciais;
	}

	public void setDataEntregasParciais(List<Date> dataEntregasParciais) {
		this.dataEntregasParciais = dataEntregasParciais;
	}*/

	@Override
	public String toString() {
		return "Cronograma{" +
				"idCronograma=" + idCronograma +
				", dataDefesa=" + dataDefesa +
				", registrado=" + registrado +
				", projeto=" + projeto +
				'}';
	}
}
