CREATE DATABASE Stock_Management_System;
USE Stock_Management_System;
CREATE TABLE User(
	userID INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(10) NOT NULL,
	CONSTRAINT PRIMARY KEY(userID)
);
INSERT INTO User(userName,email,password)VALUES('Madusha Prasad','madushaprasad21@gmail.com','1234');

CREATE TABLE Customer(
	CustID VARCHAR(15),
	FName VARCHAR(50),
	LName VARCHAR(50),
	Address VARCHAR(100),
	TelNumber VARCHAR(15),
CONSTRAINT PRIMARY KEY(CustID)
);
CREATE TABLE Volume(
	vID VARCHAR(15),
	Size VARCHAR(15),
	QTY INT,
	price DECIMAL(10,2),
CONSTRAINT PRIMARY KEY(vID)
);
CREATE TABLE Stock(
	sID VARCHAR(15),
	Date DATE,
	Price DECIMAL(10,2),
CONSTRAINT PRIMARY KEY(sID)
);
CREATE TABLE Customer_Return(
	CustID VARCHAR(15),
	sID VARCHAR(15),
	CR_ID VARCHAR(15),
	Reason VARCHAR(50),
CONSTRAINT PRIMARY KEY(CR_ID),
CONSTRAINT FOREIGN KEY(sID) REFERENCES Stock(sID)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(CustID) REFERENCES Customer(CustID)
ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE Item_Batch(
	sID VARCHAR(15),
	iBID VARCHAR(15),
	mfDate DATE,
	eXDATE DATE,
	Price DECIMAL(10,2),
CONSTRAINT PRIMARY KEY(iBID),
CONSTRAINT FOREIGN KEY(sID) REFERENCES Stock(sID)
ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE item(
	iID VARCHAR(15),
	vID VARCHAR(15),
	iBID VARCHAR(15),
	MFDate DATE NOT NULL,
	EXDate DATE NOT NULL,
	ItemName VARCHAR(50),
	CONSTRAINT PRIMARY KEY(iID),
	CONSTRAINT FOREIGN KEY(vID) REFERENCES Volume(vID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(iBID) REFERENCES Item_Batch(iBID)
	ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE Customer_Return_Detail(
	iID VARCHAR(15)NOT NULL,
	CR_ID VARCHAR(15)NOT NULL,
	date DATE,
	QTY INT(100),
	price DECIMAL(10,2),
CONSTRAINT PRIMARY KEY(CR_ID,iID),
CONSTRAINT FOREIGN KEY(CR_ID) REFERENCES Customer_Return(CR_ID)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(iID) REFERENCES item(iID)
ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE OrderType(
	oTID VARCHAR(15),
	type VARCHAR(10),
CONSTRAINT PRIMARY KEY(oTID)
);
CREATE TABLE Orders(
	CustID VARCHAR(15),
	oID VARCHAR(15),
	oTID VARCHAR(15),
	date DATE,
CONSTRAINT PRIMARY KEY(oID),
CONSTRAINT FOREIGN KEY(CustID) REFERENCES Customer(CustID)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(oTID) REFERENCES OrderType(oTID)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE OrderDetails(
	iID VARCHAR(15)NOT NULL,
	oID VARCHAR(15)NOT NULL,
	qty INT(10),
	UnitPrice DECIMAL(6,2) NOT NULL,
CONSTRAINT PRIMARY KEY(oID,iID),
CONSTRAINT FOREIGN KEY(iID) REFERENCES item(iID)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(oID) REFERENCES Orders(oID)
ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE Discard(
	iID VARCHAR(15),
	sID VARCHAR(15),
	dis_ID VARCHAR(15),
	Discription VARCHAR(100),
	QTY INT(100),
CONSTRAINT PRIMARY KEY(dis_ID),
CONSTRAINT FOREIGN KEY(sID) REFERENCES Stock(sID)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(iID) REFERENCES item(iID)
ON UPDATE CASCADE ON DELETE CASCADE
);