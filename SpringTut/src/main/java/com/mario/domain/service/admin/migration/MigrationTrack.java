package com.mario.domain.service.admin.migration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by mario on 08.12.16.
 */

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
@Data
public class MigrationTrack
	implements Serializable {

	@XmlAttribute
	private Integer trackId;

	@XmlAttribute
	private Integer year;

	@XmlAttribute
	private String title;

	@XmlAttribute
	private String subTitle;

	@XmlAttribute
	private Integer serialNo;

	@XmlAttribute
	private String director;

	@XmlAttribute
	private String trackType;
}
