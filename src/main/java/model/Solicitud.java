package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_solicitud")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_solicitud")
	private Integer nroSolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_actividad")
	private Actividad actividad;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "archivo_adjunto")
	private String archivoAdjunto;
	
	@Column(name = "fecha_reg")
	private LocalDate fechaReg;
	
	public String getEstadoDescripcion() {
		switch (estado) {
		case "PE":
			return "Pendiente";
		case "AC":
			return "Activo";
		case "AN":
			return "Anulado";
		default:
			return "Desconocido";
		}
	}
}
