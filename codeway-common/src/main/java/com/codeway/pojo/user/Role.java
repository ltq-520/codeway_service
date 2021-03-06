package com.codeway.pojo.user;

import com.codeway.pojo.BasePojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "us_role")
public class Role extends BasePojo implements Serializable {

	@ApiModelProperty("角色关联的资源")
	@ManyToMany
    @org.hibernate.annotations.ForeignKey(name = "none")
	@JoinTable(name = "us_role_resource",
			joinColumns = @JoinColumn(name = "role_id",referencedColumnName="id",foreignKey=@ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT) ),
			inverseJoinColumns = @JoinColumn(name = "resource_id",referencedColumnName="id",foreignKey=@ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT)))
	private Set<Resource> resources = new HashSet<>();

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
    @org.hibernate.annotations.ForeignKey(name = "none")
	private Set<User> users = new HashSet<>();


    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.codeway.config.IdGeneratorConfig")
    @ApiModelProperty("角色表主键")
    @Column(name="id", unique=true, nullable=false, updatable=false, length = 20)
    private String id;

    @NotNull(message = "角色名称不能为空")
    @ApiModelProperty("角色名称")
    @Column(length = 20)
    private String roleName;

    @ApiModelProperty("角色描述")
    @Column(length = 200)
    private String roleDesc;

    @NotNull(message = "角色编码不能为空")
    @ApiModelProperty("角色编码")
    @Column(length = 20)
    private String roleCode;

}