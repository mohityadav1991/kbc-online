package com.kbc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "user_answers")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAnswers {
}
