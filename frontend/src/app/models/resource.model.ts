export interface ResourceModel {
    name?: string;
    tags?: string[];
    code?: string;
    description?: string;
    qr?: string;
    url?: string;
    price?: any;
    taken?: boolean;
    likes?: number;
    canLike?: boolean;
}
