package com.trungle.littlepetshop.model;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class DateAudit implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public String getCreatedAtString() {
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

        return formatter.format(this.createdAt);
    }

    public String getUpdatedAtString() {
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

        return formatter.format(this.updatedAt);
    }
}
