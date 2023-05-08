package com.facebookweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FriendList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long friendId;
	
	String receiverfriend;
	//String senderfriend;
	
	@ManyToOne
	FacebookUser fl;
	
	String status;

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public String getReceiverfriend() {
		return receiverfriend;
	}

	public void setReceiverfriend(String receiverfriend) {
		this.receiverfriend = receiverfriend;
	}

	public FacebookUser getFl() {
		return fl;
	}

	public void setFl(FacebookUser fl) {
		this.fl = fl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
