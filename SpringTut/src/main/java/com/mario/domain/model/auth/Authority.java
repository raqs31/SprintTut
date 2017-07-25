package com.mario.domain.model.auth;

import com.mario.domain.model.AuditableEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by raqsW on 2016-08-18.
 */
@Data
@Entity
@Table( name = "AUTHORITIES" )
@NoArgsConstructor
public class Authority
	extends AuditableEntity<Authority.Role> {

	@Id
	@Column( name = "AUTHORITY" )
	@Enumerated( value = EnumType.STRING )
	private Role authority;

	@ManyToMany( mappedBy = "authorities" )
	private List<User> userWithAuthority;

	public Authority( Role r ) {
		this.authority = r;
	}

	@Override
	public Role getId() {
		return authority;
	}

	@Override
	public void setId( Role newId ) {
		this.authority = newId;
	}

	public enum Role {
		AKTOR, AGENCJA, ADMINISTRATOR( "/admin/**" );

		private List<String> grantForMatch;

		Role() {
			grantForMatch = Collections.emptyList();
		}

		Role( String... matches ) {
			grantForMatch = Collections.unmodifiableList( Arrays.stream( matches ).collect( Collectors.toList() ) );
		}

		public List<String> getGrantForMatch() {
			return grantForMatch;
		}
	}
}
