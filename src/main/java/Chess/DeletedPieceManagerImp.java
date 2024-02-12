package Chess;


    public class DeletedPieceManagerImp implements IDeletedPieceManager {
        private MyList<Piece> pieces;

        public DeletedPieceManagerImp() {
            pieces=new MyList<>();;
        }

        @Override
        public void addPiece(Piece piece) {
            pieces.addHead(piece);
        }

        @Override
        public Piece removeLast() {
            Piece info= pieces.get(0);
            pieces.remove(0);
            return info;
        }

        @Override
        public int count(Piece.Type type) {
            int cantidad=0;
            for(int i=0;i< pieces.size();i++)
                if (pieces.get(i).getType().equals(type))
                    cantidad++;

            return cantidad;
        }



    }

