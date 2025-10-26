package fr.univtours.polytech.tpeval.model.business;

import fr.univtours.polytech.tpeval.model.BorrowedListBean;

public class BorrowBusinessImpl implements BorrowBusiness{

    @Override
    public BorrowedListBean makeList(BorrowedListBean borrowedList) {
        Integer booksAmount = borrowedList.getBooks().size();
        borrowedList.setBooksNumber(booksAmount);

        return borrowedList;
    }

}
