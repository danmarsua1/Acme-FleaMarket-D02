
package acme.entities.creditCards;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				holderName;

	@NotBlank
	@CreditCardNumber
	private String				number;

	@NotBlank
	private String				brand;

	@NotNull
	@Min(value = 0)
	@Max(value = 12)
	private Integer				month;

	@NotNull
	private Integer				year;

	@NotBlank
	@Pattern(regexp = "^\\d{3,4}$", message = "{master.custom-errors.creditCard.cvv}")
	private String				cvv;

}