package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryroom")
public class RecoveryRoom extends BaseEntity{
	
	
	@Column(name = "name")
    @Size(min = 3, max = 50)
    String name;
	

	@Column(name = "size")
	@Min(value = 0)
    double size;
	
	@Column(name = "secure")
    boolean secure;

    
    @Transient
    RecoveryRoomType roomType;
}
