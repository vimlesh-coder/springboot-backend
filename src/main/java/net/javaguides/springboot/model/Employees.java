package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;


import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Entity

@Table(name="emp")

public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(name = "first_name", nullable = false)
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "emailVimlesh")
	public String emailVimlesh;

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailVimlesh() {
		return emailVimlesh;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailVimlesh(String emailVimlesh) {
		this.emailVimlesh = emailVimlesh;
	}

    public Employees() {
        super();
    }

    public Employees(long id, String firstName, String lastName, String emailVimlesh) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailVimlesh = emailVimlesh;
	}

	@Override
	public String toString() {
		return "Employees{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", emailVimlesh='" + emailVimlesh + '\'' +
				'}';
	}
}